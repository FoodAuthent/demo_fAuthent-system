package org.foodauthent.elasticsearch.impl

import java.io.InputStream
import java.util.Collections

import scala.collection.Set
import scala.io.Source
import scala.reflect.ClassTag
import scala.reflect.ManifestFactory

import org.apache.http.entity.StringEntity
import org.apache.http.message.BasicHeader
import org.elasticsearch.action.delete.DeleteRequest
import org.elasticsearch.action.get.GetRequest
import org.elasticsearch.action.get.MultiGetRequest
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.action.update.UpdateRequest
import org.elasticsearch.client.ResponseException
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.common.xcontent.XContentType
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.elasticsearch.search.fetch.subphase.FetchSourceContext
import org.elasticsearch.search.sort.FieldSortBuilder
import org.foodauthent.elasticsearch.impl.ElasticsearchUtil.SearchResult
import org.foodauthent.elasticsearch.impl.ElasticsearchUtil.SearchResultItem
import org.foodauthent.model.json.ObjectMapperUtil
import com.fasterxml.jackson.databind.ObjectMapper
import org.json4s.jackson.Json4sScalaModule
import org.slf4j.LoggerFactory
import java.lang.reflect.{ Type, ParameterizedType }
import com.fasterxml.jackson.core.`type`.TypeReference
import collection.JavaConverters._

/**
 * Commonly used operations for communicating with Elasticsearch
 * wraps save, search, list and update operations for scala case class model entities
 * @constructor create new ElasticsearchOperation using RestClientBuilder
 *
 * @author Sven Böckelmann
 */
class ElasticsearchOperation(val client: RestHighLevelClient) {

  val mapper = ObjectMapperUtil.newObjectMapper.registerModule(new Json4sScalaModule)

  /**
   * log4j logger
   */
  val LOG = LoggerFactory.getLogger(getClass)

  def write[T <: AnyRef](value: T): String = {
    mapper.writeValueAsString(value)
  }

  def read[T](json: String)(implicit mf: Manifest[T]): T = {
    mapper.readValue(json, typeReference[T](mf))
  }

  private[this] def typeReference[T](mf: Manifest[T]) = new TypeReference[T] {
    override def getType = typeFromManifest(mf)
  }

  private[this] def typeFromManifest(m: Manifest[_]): Type =
    if (m.typeArguments.isEmpty) m.runtimeClass
    else new ParameterizedType {
      def getRawType = m.runtimeClass

      def getActualTypeArguments = m.typeArguments.map(typeFromManifest).toArray

      def getOwnerType = null
    }

  /**
   * save model entity to Elasticsearch
   *
   * @param T entity type
   * @param id optional id
   * @param value model entity
   * @param target implicit Elasticsearch target with index name and type
   * @return true when successfully saved
   */
  def save[T <: AnyRef](id: Option[String], value: T)(implicit target: Target): Boolean = {
    val json = write(value)
    save[T](target.indexName, target.typeName, id, value)
  }

  /**
   * save model entity to Elasticsearch without implicit Target
   *
   * @param T entity type
   * @param indexName name of Elasticsearch index
   * @param typeName of Elasticsearch type
   * @param id optional id
   * @param value model entity
   * @return true when successfully saved
   */
  def save[T <: AnyRef](indexName: String, typeName: String, id: Option[String], value: T): Boolean = {
    val request = if (id.isDefined) new IndexRequest(indexName, typeName, id.get) else new IndexRequest(indexName, typeName)
    val json = write(value)
    request.source(json, XContentType.JSON)
    try {
      val response = client.index(request)
      return (response.status.getStatus >= 200 && response.status.getStatus < 300)
    } catch {
      case t: Throwable => {
        LOG.error(json, t)
      }
    }
    false
  }

  /**
   * get model entity from Elasticsearch
   *
   * @param T entity type
   * @param id
   * @param target implicit Elasticsearch target with index name and type
   * @param value model entity
   * @return optional entity, defined when found
   */
  def get[T](id: String)(implicit target: Target, mf: Manifest[T]): Option[T] = {
    get[T](target.indexName, target.typeName, id)
  }

  /**
   * get model entity from Elasticsearch without implicit Target
   *
   * @param T entity type
   * @param indexName name of Elasticsearch index
   * @param typeName of Elasticsearch type
   * @param id
   * @return optional entity, defined when found
   */
  def get[T](indexName: String, typeName: String, id: String)(implicit mf: Manifest[T]): Option[T] = {
    val request = new GetRequest(indexName, typeName, id)
    val response = client.get(request);
    if (response.isExists()) {
      Option(read[T](response.getSourceAsString))
    } else {
      Option.empty[T]
    }
  }

  /**
   * get multiple model entities from Elasticsearch
   *
   * @param T entity type
   * @param ids
   * @param target implicit Elasticsearch target with index name and type
   * @param value model entity
   * @return sequence of optional entities, defined when found
   */
  def get[T](ids: Set[String])(implicit target: Target, mf: Manifest[T]): Seq[Option[T]] = {
    get[T](target.indexName, target.typeName, ids)
  }

  /**
   * get multiple model entities from Elasticsearch without implicit Target
   *
   * @param T entity type
   * @param indexName name of Elasticsearch index
   * @param typeName of Elasticsearch type
   * @param ids
   * @return sequence of optional entities, defined when found
   */
  def get[T](indexName: String, typeName: String, ids: Set[String])(implicit mf: Manifest[T]): Seq[Option[T]] = {
    val request = new MultiGetRequest()
    ids.foreach(f => {
      request.add(indexName, typeName, f)
    })
    try {
      val response = client.multiGet(request)
      response.getResponses.map(r => {
        if (r.getResponse.isExists()) {
          Option(read[T](r.getResponse.getSourceAsString))
        } else {
          None
        }
      })
    } catch {
      case e: Exception => {
        Seq.empty[Option[T]]
      }
    }
  }

  /**
   * update model entity in Elasticsearch
   *
   * @param T entity type
   * @param id
   * @param value model entity
   * @param target implicit Elasticsearch target with index name and type
   * @return true when successfully updated
   */
  def update[T <: AnyRef](id: String, value: T)(implicit target: Target): Boolean = {
    update[T](target.indexName, target.typeName, id, value)
  }

  /**
   * update model entity in Elasticsearch without implicit Target
   *
   * @param T entity type
   * @param indexName name of Elasticsearch index
   * @param typeName of Elasticsearch type
   * @param id
   * @param value model entity
   * @return true when successfully updated
   */
  def update[T <: AnyRef](indexName: String, typeName: String, id: String, value: T): Boolean = {
    if (!client.get(new GetRequest(indexName, typeName, id).fetchSourceContext(new FetchSourceContext(false))).isExists()) {
      return false
    }
    save[T](indexName, typeName, Option(id), value)
  }

  /**
   * patch model entity in Elasticsearch
   *
   * @param T entity type (generally a map)
   * @param id
   * @param value model entity
   * @param target implicit Elasticsearch target with index name and type
   * @return optional entity, defined when found
   */
  def patch[T <: AnyRef](id: String, value: T)(implicit target: Target, mf: Manifest[T]): Option[T] = {
    patch[T](target.indexName, target.typeName, id, value)
  }

  /**
   * patch model entity in Elasticsearch without implicit Target
   *
   * @param T entity type (generally a map)
   * @param indexName name of Elasticsearch index
   * @param typeName of Elasticsearch type
   * @param id
   * @param value model entity
   * @return optional entity, defined when found
   */
  def patch[T <: AnyRef](indexName: String, typeName: String, id: String, value: T)(implicit mf: Manifest[T]): Option[T] = {
    if (!client.get(new GetRequest(indexName, typeName, id).fetchSourceContext(new FetchSourceContext(false))).isExists()) {
      return Option.empty[T]
    }
    val request = new UpdateRequest(indexName, typeName, id).fetchSource(true)
    request.doc(write[T](value), XContentType.JSON)
    Option(read[T](client.update(request).getGetResult.sourceAsString()))
  }

  /**
   * delete model entity from Elasticsearch by id
   *
   * @param id
   * @param target implicit Elasticsearch target with index name and type
   * @return true when successfully deleted
   */
  def delete(id: String)(implicit target: Target): Boolean = {
    delete(target.indexName, target.typeName, id)
  }

  /**
   * delete model entity from Elasticsearch by id without implicit Target
   *
   * @param indexName name of Elasticsearch index
   * @param typeName of Elasticsearch type
   * @param id
   * @return true when successfully deleted
   */
  def delete(indexName: String, typeName: String, id: String): Boolean = {
    val response = client.delete(new DeleteRequest(indexName, typeName, id))
    if (LOG.isDebugEnabled()) {
      LOG.debug("DELETED " + id + ": status " + response.status().getStatus)
    }
    (response.status().getStatus == 200)
  }

  /**
   * perform matchAll query for model entity on Elasticsearch
   *
   * @param T entity type to be returned in list
   * @param from elasticsearch search from paramater
   * @param size elasticsearch search size paramater
   * @param target implicit Elasticsearch target with index name and type
   * @return list of T
   */
  def list[T <: AnyRef](from: Int, size: Int)(implicit target: Target, mf: Manifest[T]): Array[T] = {
    list[T](target.indexName, target.typeName, from, size)
  }

  /**
   * perform matchAll query for model entity on Elasticsearch without implicit Target
   *
   * @param T entity type to be returned in list
   * @param indexName name of Elasticsearch index
   * @param typeName of Elasticsearch type
   * @param from elasticsearch search from paramater
   * @param size elasticsearch search size paramater
   * @return list of T
   */
  def list[T <: AnyRef](indexName: String, typeName: String, from: Int, size: Int)(implicit mf: Manifest[T]): Array[T] = {
    val request = new SearchRequest(indexName).types(typeName)
    val sourceBuilder = new SearchSourceBuilder()
    sourceBuilder.query(QueryBuilders.matchAllQuery())
    sourceBuilder.from(from)
    sourceBuilder.size(size)
    request.source(sourceBuilder)
    val response = client.search(request)
    response.getHits.getHits.map(f => {
      read[T](f.getSourceAsString)
    })
  }

  /**
   * get list of document IDs in Elasticsearch for given QueryBuilder
   *
   * @param query Elasticsearch QueryBuilder for executing search
   * @param target implicit Elasticsearch target with index name and type
   * @return list of Elasticsearch Document IDs matching QueryBuilder, None if nothing was was found
   */
  def exists(query: QueryBuilder)(implicit target: Target): Option[List[String]] = {
    exists(query, target.indexName, target.typeName)
  }

  /**
   * get list of document IDs in Elasticsearch for given QueryBuilder without implicit Target
   *
   * @param indexName name of Elasticsearch index
   * @param typeName of Elasticsearch type
   * @param query Elasticsearch QueryBuilder for executing search
   * @return list of Elasticsearch Document IDs matching QueryBuilder, None if nothing was was found
   */
  def exists(query: QueryBuilder, indexName: String, typeName: String): Option[List[String]] = {
    val request = new SearchRequest(indexName).types(typeName)
    val sourceBuilder = new SearchSourceBuilder()
    sourceBuilder.query(query)
    sourceBuilder.fetchSource(false)
    request.source(sourceBuilder)
    val response = client.search(request)
    if (response.getHits.getTotalHits == 0) {
      return None
    }
    return Option(response.getHits.getHits.map(h => {
      h.getId
    }).toList)
  }

  /**
   * Perform SearchRequest on Elasticsearch.
   * Results will be returned SearchResult which provides information for hits.
   *
   * @param T entity type to be used in result
   * @param request Elasticsearch SearchRequest for executing search
   * @param target implicit Elasticsearch target with index name and type
   * @return SearchResult with totalHits and list of results
   */
  def search[T](request: SearchRequest)(implicit mf: Manifest[T]): SearchResult[T] = {
    val response = client.search(request)
    if (response.getHits.getTotalHits == 0) {
      return new SearchResult(0, List.empty[SearchResultItem[T]])
    }
    return new SearchResult(response.getHits.getTotalHits, response.getHits.getHits.map(h => {
      new SearchResultItem(h.getId, h.getScore, h.getIndex, h.getType, read[T](h.getSourceAsString))
    }).toList)
  }

  /**
   * Perform search on Elasticsearch using QueryBuilder.
   * Results will be returned as simple list without additional information
   *
   * @param T entity type to be used in result
   * @param query Elasticsearch QueryBuilder for executing search
   * @param target implicit Elasticsearch target with index name and type
   * @return list of results
   */
  def search[T](query: QueryBuilder)(implicit target: Target, mf: Manifest[T]): java.util.List[T] = {
    search(query, target.indexName, target.typeName)
  }

  /**
   * Create new SearchReqeuest for implicit Target
   *
   * @param target implicit Elasticsearch target with index name and type
   * @return SearchRequest for Target
   */
  def searchRequest()(implicit target: Target): SearchRequest = {
    new SearchRequest(target.indexName).types(target.typeName).preference(target.typeName)
  }

  /**
   * Create new SearchReqeuest without implicit Target
   *
   * @param indexName name of Elasticsearch index
   * @param typeName of Elasticsearch type
   * @return SearchRequest for indexName and typeName
   */
  def searchRequest(indexName: String, typeName: String): SearchRequest = {
    new SearchRequest(indexName).types(typeName)
  }

  /**
   * Perform search on Elasticsearch using QueryBuilder without implicit Target.
   * Results will be returned as simple list without additional information
   *
   * @param T entity type to be used in result
   * @param indexName name of Elasticsearch index
   * @param typeName of Elasticsearch type
   * @param query Elasticsearch QueryBuilder for executing search
   * @return list of results
   */
  def search[T](query: QueryBuilder, indexName: String, typeName: String)(implicit mf: Manifest[T]): java.util.List[T] = {
    val request = searchRequest(indexName, typeName)
    val sourceBuilder = new SearchSourceBuilder()
    sourceBuilder.query(query)
    request.source(sourceBuilder)
    val response = client.search(request)
    if (response.getHits.getTotalHits == 0) {
      return List.empty[T].asJava
    }
    return response.getHits.getHits.map(h => {
      read[T](h.getSourceAsString)
    }).toList.asJava
  }

  /**
   * Perform search and sort on Elasticsearch using QueryBuilder and FieldSortBuilder.
   * Results will be returned as simple list without additional information
   *
   * @param T entity type to be used in result
   * @param query Elasticsearch QueryBuilder for executing search
   * @param sort Elasticsearch FieldSortBuilder for sorting
   * @param target implicit Elasticsearch target with index name and type
   * @return list of results
   */
  def search[T](query: QueryBuilder, sort: FieldSortBuilder)(implicit target: Target, mf: Manifest[T]): List[T] = {
    search(query, sort, target.indexName, target.typeName)
  }

  /**
   * Perform search and sort on Elasticsearch using QueryBuilder and FieldSortBuilder without implicit Target.
   * Results will be returned as simple list without additional information on totalHits
   *
   * @param T entity type to be used in result
   * @param query Elasticsearch QueryBuilder for executing search
   * @param sort Elasticsearch FieldSortBuilder for sorting
   * @param indexName name of Elasticsearch index
   * @param typeName of Elasticsearch type
   * @return list of results
   */
  def search[T](query: QueryBuilder, sort: FieldSortBuilder, indexName: String, typeName: String)(implicit mf: Manifest[T]): List[T] = {
    val request = searchRequest(indexName, typeName)
    val sourceBuilder = new SearchSourceBuilder()
    sourceBuilder.query(query)
    sourceBuilder.sort(sort)
    request.source(sourceBuilder)
    val response = client.search(request)
    if (response.getHits.getTotalHits == 0) {
      return List.empty[T]
    }
    return response.getHits.getHits.map(h => {
      read[T](h.getSourceAsString)
    }).toList
  }

  /**
   * get model entity from Elasticsearch
   *
   * @param T entity type
   * @param id
   * @param target implicit Elasticsearch target with index name and type
   * @param value model entity
   * @return optional entity, defined when found
   */
  def manifest[T](clazz: Class[T]): Manifest[T] = {
    ManifestFactory.classType[T](clazz)
  }
  
  
  def resultAsJava[T](result:ElasticsearchUtil.SearchResult[T], clazz:Class[T]) : java.util.List[SearchResultItem[T]] = {
    result.result.asJava
  }
  
}

/**
 * Configuration case class containing details about Elasticsearch "target".
 * Elasticsearch stores documents in seperate indices which may contain several types.
 */
case class Target(
  /**
   * Elasticsearch index name to operate with
   */
  indexName: String,
  /**
   * Elasticsearch type name to operate with
   */
  typeName: String)

/**
 * Utility for setting up indices in Elasticsearch
 */
object ElasticsearchUtil {

  /**
   * log4j logger
   */
  val LOG = LoggerFactory.getLogger(getClass)

  /**
   * use settings from input and create new index if it does not exist
   *
   * @param restClient client to operate with
   * @param indexName name of new index
   * @param input optional index settings as InputStream
   * @param typeMap map containing typeName replacement patterns for adjusting type names in index settings
   * @return true if index was created
   */
  def setupIndex(restClient: RestHighLevelClient, indexName: String, input: Option[InputStream], typeMap: Option[Map[String, String]]): Boolean = {
    // regexp replacement of type names in settings
    var settings = if (input.isDefined) Option(Source.fromInputStream(input.get).mkString) else None
    if (settings.isDefined && typeMap.isDefined) {
      typeMap.get.foreach(f => {
        settings = Option(settings.get.replaceAll(f._1, f._2))
      })
    }
    setupIndex(restClient, indexName, settings)
  }
  
  /**
   * use settings from json string and create new index if it does not exist
   *
   * @param restClient client to operate with
   * @param indexName name of new index
   * @param input optional index settings as String
   * @return true if index was created
   */
  def setupIndex(restClient: RestHighLevelClient, indexName: String, indexConfig: Option[String]): Boolean = {
    // current Elasticsearch RestHighLevelClient does not support index admin yet, therefore we have to do client calls on LowLevelClient
    try {
      val entity: StringEntity = if (indexConfig.isDefined) new StringEntity(indexConfig.get) else null
      val response = restClient.getLowLevelClient.performRequest("PUT", "/" + indexName, Collections.emptyMap[String, String](), entity, new BasicHeader("content-type", "application/json"));
    } catch {
      case e: ResponseException => {
        // Exception could mean that index simply already exists
        if (e.getResponse().getStatusLine().getStatusCode() == 400 &&
          (e.getMessage().contains("index_already_exists_exception") || // ES 5.x
            e.getMessage().contains("resource_already_exists_exception") || // ES 6.x
            e.getMessage().contains("IndexAlreadyExistsException") ||
            e.getMessage().contains("already exists as alias"))) {
          LOG.info("index ".concat(indexName).concat(" already exists"))
          return false
        } else {
          throw e
        }
      }
    }
    return true
  }

  /**
   * check if index exists
   *
   * @param restClient client to operate with
   * @param indexName name of index to look foor
   * @return true if index exists
   */
  def indexExists(restClient: RestHighLevelClient, indexName: String): Boolean = {
    try {
      val response = restClient.getLowLevelClient.performRequest("HEAD", "/" + indexName)
      val statusCode = response.getStatusLine().getStatusCode();
      return statusCode != 404
    } catch {
      case ex: Exception => {
        return false
      }
    }
  }

  /**
   * Complex case class with detailed information on hits
   */
  case class SearchResult[T](
    /**
     * total hits found
     */
    resultTotalCount: Long,
    /**
     * list of hits with detailed information
     */
    result: List[SearchResultItem[T]])

  /**
   * Complex case class for each hit found containing serialized entity and detailed information on hit
   */
  case class SearchResultItem[T](
    /**
     * Elasticsearch document ID
     */
    id: String,
    /**
     * Elasticsearch score for hit
     */
    score: Float,
    /**
     * name of Elasticsearch index the hit was found
     */
    index: String,
    /**
     * Elasticsearch type for hit
     */
    indexType: String,
    /**
     * serialized entity for hit document source
     */
    item: T)

}

