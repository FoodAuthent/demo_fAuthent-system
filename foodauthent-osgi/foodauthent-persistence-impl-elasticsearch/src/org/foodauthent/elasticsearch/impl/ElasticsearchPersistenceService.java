package org.foodauthent.elasticsearch.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.foodauthent.api.internal.exception.ModelExistsException;
import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.api.internal.persistence.PersistenceServiceProvider;
import org.foodauthent.elasticsearch.ClientService;
import org.foodauthent.elasticsearch.ClientServiceListener;
import org.foodauthent.elasticsearch.impl.ElasticsearchUtil.SearchResult;
import org.foodauthent.elasticsearch.impl.ElasticsearchUtil.SearchResultItem;
import org.foodauthent.model.FaModel;
import org.foodauthent.model.Product;
import org.foodauthent.storage.FileStorageService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
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
			return saveToFileStorageService(blob);
		} else {
			return saveToElasticsearch(blob);
		}
	}

	private UUID saveToFileStorageService(Blob blob) throws ModelExistsException {
		try {
			if (fileStorageService.exists(blob.getFaId())) {
				throw new ModelExistsException("An entity with the given id already exists.");
			}
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
	public <T extends FaModel> List<T> findByKeywords(Collection<String> keywords, Class<T> modelType) {
		return op.search(QueryBuilders.simpleQueryStringQuery(String.join(" AND ", keywords)), classTarget(modelType),
				op.manifest(modelType));
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
	public <T extends FaModel> ResultPage<T> findByKeywordsPaged(Collection<String> keywords, Class<T> modelType,
			int pageNumber, int pageSize) {
		final SearchRequest request = op.searchRequest(classTarget(modelType));
		final SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		if (keywords.isEmpty()) {
			sourceBuilder.query(QueryBuilders.matchAllQuery());
		} else {
			sourceBuilder.query(QueryBuilders.simpleQueryStringQuery(String.join(" AND ", keywords)));
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
	public void removeFaModelByUUID(UUID uuid, Class<?> modelType) {
		op.delete(uuid.toString(), classTarget(modelType));
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
}
