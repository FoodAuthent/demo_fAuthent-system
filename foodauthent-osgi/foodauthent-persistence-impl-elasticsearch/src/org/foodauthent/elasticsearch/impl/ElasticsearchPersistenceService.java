package org.foodauthent.elasticsearch.impl;

import static java.util.Arrays.stream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.security.DigestInputStream;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.foodauthent.api.internal.exception.ModelExistsException;
import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceServiceProvider;
import org.foodauthent.elasticsearch.ClientService;
import org.foodauthent.elasticsearch.ClientServiceListener;
import org.foodauthent.elasticsearch.impl.ElasticsearchOperation.IdResult;
import org.foodauthent.elasticsearch.impl.ElasticsearchUtil.SearchResult;
import org.foodauthent.elasticsearch.impl.ElasticsearchUtil.SearchResultItem;
import org.foodauthent.model.BizTransaction;
import org.foodauthent.model.DiscoveryServiceSearchFilter;
import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.DiscoveryServiceTransactionPageResult;
import org.foodauthent.model.FaModel;
import org.foodauthent.model.Product;
import org.foodauthent.storage.FileStorageService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.foodauthent.digest.DigestUtil;
import com.google.common.io.CharStreams;

import scala.Option;

/**
 * Persistence Service for persisting data object to elasticsearch cluster
 *
 * @author Sven Böckelmann
 *
 */
@Component(service = { PersistenceServiceProvider.class, ClientServiceListener.class }, immediate = true)
public class ElasticsearchPersistenceService implements PersistenceServiceProvider, ClientServiceListener {

	@Reference(service = FileStorageService.class, bind = "bindFileStorageService", unbind = "unbindFileStorageService")
	private FileStorageService fileStorageService;

	private ElasticsearchOperation op;

	private Map<String, Target> targets = new HashMap<String, Target>();

	private static final Logger LOG = LoggerFactory.getLogger(ElasticsearchPersistenceService.class);

	public ElasticsearchPersistenceService() {
	}

	@Override
	public void clientChanged(RestHighLevelClient client) {
		if (client == null) {
			this.op = null;
		} else {
			final ElasticsearchOperation op = new ElasticsearchOperation(client);
			this.op = op;
		}
	}

	@Reference(service = ClientService.class, cardinality = ReferenceCardinality.MANDATORY)
	public void bindClientService(ClientService clientService) {
		clientChanged(clientService.getClient());
	}

	public void bindFileStorageService(FileStorageService fileStorageService) {
		this.fileStorageService = fileStorageService;
	}

	public void unbindFileStorageService(FileStorageService fileStorageService) {
		this.fileStorageService = null;
	}

	@Override
	public <T extends FaModel> T save(T entity) throws ModelExistsException {
		final Target target = classTarget(entity.getClass());
		if (op.exists(QueryBuilders.idsQuery().addIds(entity.getFaId().toString()), target).isDefined()) {
			throw new ModelExistsException("An entity with the given id already exists.");
		}
		if (op.save(Option.apply(entity.getFaId().toString()), entity, target)) {
			return entity;
		}
		throw new RuntimeException("unable to store entity");
	}

	@Override
	public <T extends FaModel> T replace(T entity) throws NoSuchElementException {
		if (op.update(entity.getFaId().toString(), entity, classTarget(entity.getClass()))) {
			return entity;
		}
		throw new NoSuchElementException();
	}

	@Override
	public UUID save(Blob blob) throws ModelExistsException {
		if (fileStorageService != null) {
			LOG.info("save data to FileStorageService");
			return saveToFileStorageService(blob);
		} else {
			LOG.info("save data to Elasticsearch");
			return saveToElasticsearch(blob);
		}
	}

	private UUID saveToFileStorageService(Blob blob) throws ModelExistsException {
		try {
			fileStorageService.save(blob.getFaId(), blob.getData());
			return blob.getFaId();
		} catch (IOException e) {
			LOG.error("unable to save blob " + blob.getFaId().toString(), e);
			throw new RuntimeException(e);
		}
	}

	private UUID saveToElasticsearch(Blob blob) throws ModelExistsException {
		Target target = blobTarget();
		if (op.exists(QueryBuilders.idsQuery().addIds(blob.getFaId().toString()), target).isDefined()) {
			throw new ModelExistsException("An entity with the given id already exists.");
		}
		ESBlob es = new ESBlob(blob);
		if (op.save(Option.apply(blob.getFaId().toString()), es, target)) {
			return blob.getFaId();
		}
		throw new RuntimeException("unable to store entity");
	}

	@Override
	public Product findProductByGtin(String gtin) {
		List<Product> products = op.search(QueryBuilders.termQuery("gtin", gtin), classTarget(Product.class),
				op.manifest(Product.class));
		if (products.isEmpty()) {
			throw new NoSuchElementException();
		}
		return products.get(0);
	}

	@Override
	public <T extends FaModel> T getFaModelByUUID(UUID uuid, Class<T> modelType) throws NoSuchElementException {
		Option<T> value = op.get(uuid.toString(), classTarget(modelType), op.manifest(modelType));
		if (value.isDefined()) {
			return value.get();
		}
		throw new NoSuchElementException();
	}

	@Override
	public <T extends FaModel> List<T> findByKeywords(Class<T> modelType, String[]... keywordSuperSet) {
		// TODO test
		String query = stream(keywordSuperSet).map(s -> String.join(" AND ", s)).map(s -> "(" + s + ")")
				.collect(Collectors.joining(" OR "));
		return op.search(QueryBuilders.simpleQueryStringQuery(query), classTarget(modelType), op.manifest(modelType));
	}

	@Override
	public Blob getBlobByUUID(UUID uuid) {
		if (fileStorageService != null) {
			return getBlobByUUIDFromFileStorageService(uuid);
		} else {
			return getBlobByUUIDFromElasticsearch(uuid);
		}
	}

	private Blob getBlobByUUIDFromFileStorageService(UUID uuid) {
		try {
			if (!fileStorageService.exists(uuid)) {
				throw new NoSuchElementException();
			}
			return new Blob(uuid, fileStorageService.load(uuid));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Blob getBlobByUUIDFromElasticsearch(UUID uuid) {
		Option<ESBlob> es = op.get(uuid.toString(), blobTarget(), op.manifest(ESBlob.class));
		if (es.isDefined()) {
			return es.get().toBlob(uuid);
		}
		throw new NoSuchElementException();
	}

	private Target classTarget(Class<?> cls) {
		Target t = targets.get(cls.getName());
		if (t == null) {
			t = new Target(cls.getSimpleName().toLowerCase(), "data");
			targets.put(cls.getName(), t);
			if (!ElasticsearchUtil.indexExists(op.client(), t.indexName())) {
				ElasticsearchUtil.setupIndex(op.client(), t.indexName(), Option.empty());
			}
		}
		return t;
	}

	private Target customModelTarget(String modelId, String schemaId) {
		final String targetKey = String.join("-", modelId, schemaId).toLowerCase();
		Target t = targets.get(targetKey);
		if (t == null) {
			t = new Target(targetKey, "data");
			targets.put(targetKey, t);
			if (!ElasticsearchUtil.indexExists(op.client(), t.indexName())) {
				ElasticsearchUtil.setupIndex(op.client(), t.indexName(), Option.empty());
			}
		}
		return t;
	}

	private Target blobTarget() {
		Target t = targets.get(Blob.class.getName());
		if (t == null) {
			t = new Target(Blob.class.getSimpleName().toLowerCase(), "data");
			String mapping;
			try {
				mapping = CharStreams.toString(new InputStreamReader(
						getClass().getResourceAsStream("/META-INF/mapping/blob-mapping.json"), "UTF-8"));
				ElasticsearchUtil.setupIndex(op.client(), t.indexName(), Option.apply(mapping));
				targets.put(Blob.class.getName(), t);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return t;
	}

	@Override
	public <T extends FaModel> ResultPage<T> findByKeywordsPaged(Class<T> modelType, int pageNumber, int pageSize,
			String[]... orgKeywordSuperSet) {
		final SearchRequest request = op.searchRequest(classTarget(modelType));
		final SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

		String[][] keywordSuperSet = PersistenceService.removeEmptyListsAndKeywords(orgKeywordSuperSet);
		if (keywordSuperSet.length == 0) {
			sourceBuilder.query(QueryBuilders.matchAllQuery());
		} else {
			// TODO test
			String query = stream(keywordSuperSet).map(s -> String.join(" AND ", s)).map(s -> "(" + s + ")")
					.collect(Collectors.joining(" OR "));
			sourceBuilder.query(QueryBuilders.simpleQueryStringQuery(query));
		}
		sourceBuilder.from((pageNumber - 1) * pageSize);
		sourceBuilder.size(pageSize);
		request.source(sourceBuilder);
		final SearchResult<T> result = op.search(request, op.manifest(modelType));
		final List<SearchResultItem<T>> res = op.resultAsJava(result, modelType);
		return new ResultPage<T>() {

			@Override
			public int getTotalNumPages() {
				return result.resultTotalCount() == 0 ? 0
						: (int) Math.ceil((float) (result.resultTotalCount() / (float) pageSize));
			}

			@Override
			public int getTotalNumEntries() {
				return (int) result.resultTotalCount();
			}

			@Override
			public List<T> getResult() {
				return res.stream().map(r -> r.item()).collect(Collectors.toList());
			}

		};

	}

	@Override
	public void removeFaModelByUUID(UUID uuid) {
		final Optional<IdResult> r = op.ids(uuid.toString());
		if (r.isPresent()) {
			op.delete(r.get().id(), r.get().target());
			// if we are deleting a filemetadata we also delete the data in the storage
			if (r.get().target().indexName().equalsIgnoreCase("filemetadata")) {
				removeBlobByUUID(uuid);
			}
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void removeBlobByUUID(UUID faId) {
		if (fileStorageService != null) {
			try {
				fileStorageService.delete(faId);
			} catch (IOException e) {
				// ignore
			}
		} else {
			op.delete(faId.toString(), blobTarget());
		}
	}

	@Override
	public void saveCustomModel(String modelId, String schemaId, UUID uuid, JsonNode model) {
		final Target target = customModelTarget(modelId, schemaId);
		op.save(Option.apply(uuid.toString()), model, target);
	}

	@Override
	public JsonNode getCustomModelByUUID(String modelId, String schemaId, UUID uuid) {
		final Target target = customModelTarget(modelId, schemaId);
		Option<JsonNode> es = op.get(uuid.toString(), target, op.manifest(JsonNode.class));
		if (es.isDefined()) {
			return es.get();
		}
		throw new NoSuchElementException();
	}

	@Override
	public int getPriority() {
		return 1;
	}

	@Override
	public Product getProductById(UUID id) {
		return getFaModelByUUID(id, Product.class);
	}

	@Override
	public <T extends FaModel> long getModelCount(Class<T> modelType) {
		final Target target = classTarget(modelType);
		return op.getDocumentCount(target.indexName());
	}

	@Override
	public long getBlobCount() {
		if (fileStorageService == null) {
			final Target target = blobTarget();
			return op.getDocumentCount(target.indexName());
		} else {
			return op.getDocumentCount("filemetadata");
		}
	}

	@Override
	public <T extends FaModel> ResultPage<T> findByRelationPaged(Class<T> modelType, int pageNumber, int pageSize,
			String referencedFieldName, UUID faId) {
		final SearchRequest request = op.searchRequest(classTarget(modelType));
		final SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		sourceBuilder.query(QueryBuilders.termQuery(referencedFieldName, faId.toString()));
		sourceBuilder.from((pageNumber - 1) * pageSize);
		sourceBuilder.size(pageSize);
		request.source(sourceBuilder);
		final SearchResult<T> result = op.search(request, op.manifest(modelType));
		final List<SearchResultItem<T>> res = op.resultAsJava(result, modelType);
		return new ResultPage<T>() {

			@Override
			public int getTotalNumPages() {
				return result.resultTotalCount() == 0 ? 0
						: (int) Math.ceil((float) (result.resultTotalCount() / (float) pageSize));
			}

			@Override
			public int getTotalNumEntries() {
				return (int) result.resultTotalCount();
			}

			@Override
			public List<T> getResult() {
				return res.stream().map(r -> r.item()).collect(Collectors.toList());
			}

		};
	}

	/**
	 * Search DiscoveryServiceTransaction by filters
	 * 
	 */
	@Override
	public DiscoveryServiceTransactionPageResult findTransactionByFilter(DiscoveryServiceSearchFilter dssf,
			int pageNumber, int pageSize) {

		BoolQueryBuilder qb = QueryBuilders.boolQuery();
		

		// QUERY FOR epcList
		if (dssf.getEpcList().size() > 0) {
			BoolQueryBuilder epcQuery = QueryBuilders.boolQuery();
			for (String epc : dssf.getEpcList()) {
				epcQuery.should(QueryBuilders.termsQuery("epcList.keyword", epc));
			}
			qb.should(epcQuery);
		}

		// QUERY FOR bizStep
		if (dssf.getBizStep() != null) {
			qb.should(QueryBuilders.termsQuery("bizStep.keyword", dssf.getBizStep()));
		}
		

		// QUERY FOR Readpoint
		if (dssf.getReadPoint() != null) {
			qb.should(QueryBuilders.termsQuery("readPoint.keyword", dssf.getReadPoint()));
		}

		// QUERY FOR QuantityList
		if (dssf.getQuantityList().size() > 0) {
			BoolQueryBuilder epcQuery = QueryBuilders.boolQuery();
			for (String epcClass : dssf.getQuantityList()) {
				epcQuery.should(QueryBuilders.termsQuery("quantityList.keyword", epcClass));
			}
			qb.should(epcQuery);
		}
		

		// QUERY FOR Action
		if (dssf.getAction() != null) {
			qb.should(QueryBuilders.termsQuery("action.keyword", dssf.getAction()));
		}

		// QUERY FOR bizTransactionList
		if (dssf.getBizTransactionList().size() > 0) {
			for (BizTransaction bt : dssf.getBizTransactionList()) {
				if (bt.getType() != null || bt.getValue() != null) {
					if (bt.getType() != null) {
						qb.should(QueryBuilders.termsQuery("bizTransactionList.type.keyword", bt.getType()));
					}
					if (bt.getValue() != null) {
						qb.should(QueryBuilders.termsQuery("bizTransactionList.value.keyword", bt.getValue()));
					}
				}
			}
		}

		// QUERY FOR GTIN
		if (dssf.getGtin() != null) {
			qb.should(QueryBuilders.termsQuery("gtin.keyword", dssf.getGtin()));
		}

		// Query for eventType
		if (dssf.getEventType() != null) {
			qb.should(QueryBuilders.termQuery("eventType.keyword", dssf.getEventType()));
		}

		// Query for interfaceId
		if (dssf.getInterfaceId() != null) {
			qb.should(QueryBuilders.termQuery("interfaceId.keyword", dssf.getInterfaceId()));
		}

		// QUERY FOR Bricks
		if (dssf.getBricks().size() > 0) {
			for (String brick : dssf.getBricks()) {
				if (brick.contains("*")) {
					qb.should(QueryBuilders.wildcardQuery("bricks.tree", brick));
				} else {
					qb.should(QueryBuilders.termQuery("bricks.raw", brick));
				}
			}
		}

		// QUERY FOR eventTime Range
		if (dssf.getEventTimeFrom() != null || dssf.getEventTimeTo() != null) {
			final RangeQueryBuilder queryBuilder = QueryBuilders.rangeQuery("eventTime");
			if (dssf.getEventTimeFrom() != null) {
				// queryBuilder.gte(Date.from(dssf.getEventTimeFrom().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()).getTime());
				queryBuilder.from(dssf.getEventTimeFrom().toString());
			}
			if (dssf.getEventTimeTo() != null) {
				// queryBuilder.lte(Date.from(dssf.getEventTimeTo().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()).getTime());
				queryBuilder.to(dssf.getEventTimeTo().toString());
			}

			qb.should(queryBuilder);
		}
		qb.minimumShouldMatch("100%");
		SearchRequest request = op.searchRequest(classTarget(DiscoveryServiceTransaction.class));
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//		sourceBuilder.query(QueryBuilders.simpleQueryStringQuery(qb.toString()));
		sourceBuilder.query(qb);
		sourceBuilder.from((pageNumber - 1) * pageSize);
		sourceBuilder.size(pageSize);
		request.source(sourceBuilder);
	
		SearchResult<DiscoveryServiceTransaction> result = op.search(request, op.manifest(DiscoveryServiceTransaction.class));
		List<SearchResultItem<DiscoveryServiceTransaction>> res = op.resultAsJava(result, DiscoveryServiceTransaction.class);
		List<DiscoveryServiceTransaction> transaction = res.stream().map(r -> r.item()).collect(Collectors.toList());
		
		System.out.println("Query: " + qb);
		System.out.println("Query request: " + request);
		
//		List<DiscoveryServiceTransaction> transaction = op.search(qb, classTarget(DiscoveryServiceTransaction.class),
//				op.manifest(DiscoveryServiceTransaction.class));

		if (transaction.isEmpty()) {
			 throw new NoSuchElementException();
		}

		return DiscoveryServiceTransactionPageResult.builder().setPageCount((int)transaction.size() / pageSize).setPageNumber(pageNumber)
				.setResults(transaction).setResultCount(transaction.size()).build();
		
	}

	@Override
	public String getBlobSHA256(UUID uuid) throws NoSuchElementException {
		if (fileStorageService != null) {
			try {
				return fileStorageService.getSHA256(uuid);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		final Blob blob = getBlobByUUID(uuid);
		if (blob != null) {
			try {
				final DigestInputStream d = DigestUtil.sha256DigestInputStream(blob.getData());
				IOUtils.copy(d, new NullOutputStream());
				return DigestUtil.toHex(d.getMessageDigest());
			} catch (NoSuchAlgorithmException | IOException e) {
				throw new RuntimeException(e);
			}
		}
		return null;

	}

}
