package org.foodauthent.elasticsearch.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.elasticsearch.index.query.QueryBuilders;
import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.common.exception.EntityExistsException;
import org.foodauthent.elasticsearch.ClientService;
import org.foodauthent.model.FaModel;
import org.foodauthent.model.Product;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.google.common.io.CharStreams;

import scala.Option;

/**
 * Persistence Service for persisting data object to elasticsearch cluster 
 *
 * @author Sven Böckelmann
 *
 */
@Component(service = PersistenceService.class)
public class ElasticsearchPersistenceService implements PersistenceService {

	private ElasticsearchOperation op;

	private Map<Class<?>, Target> targets = new HashMap<Class<?>, Target>();

	@Reference
	public void bindClientService(ClientService clientService) {
		op = new ElasticsearchOperation(clientService.getClient());
	}

	@Override
	public <T extends FaModel> T save(T entity) throws EntityExistsException {
		final Target target = classTarget(entity.getClass());
		if (op.exists(QueryBuilders.idsQuery().addIds(entity.getFaId().toString()), target).isDefined()) {
			throw new EntityExistsException("An entity with the given id already exists.");
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
	public UUID save(Blob blob) throws EntityExistsException {
		Target target = blobTarget();
		if (op.exists(QueryBuilders.idsQuery().addIds(blob.getFaId().toString()), target).isDefined()) {
			throw new EntityExistsException("An entity with the given id already exists.");
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
		Option<ESBlob> es = op.get(uuid.toString(), blobTarget(), op.manifest(ESBlob.class));
		if (es.isDefined()) {
			return es.get().toBlob(uuid);
		}
		throw new NoSuchElementException();
	}

	private Target classTarget(Class<?> cls) {
		Target t = targets.get(cls);
		if (t == null) {
			t = new Target(cls.getSimpleName().toLowerCase(), "data");
			targets.put(cls, t);
		}
		return t;
	}

	private Target blobTarget() {
		Target t = targets.get(Blob.class);
		if (t == null) {
			t = new Target(Blob.class.getSimpleName().toLowerCase(), "data");
			String mapping;
			try {
				mapping = CharStreams.toString(new InputStreamReader(
						getClass().getResourceAsStream("/META-INF/mapping/blob-mapping.json"), "UTF-8"));
				ElasticsearchUtil.setupIndex(op.client(), t.indexName(), Option.apply(mapping));
				targets.put(Blob.class, t);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return t;
	}

	@Override
	public <T extends FaModel> PagedResult<T> findByKeywordsPaged(Collection<String> keywords, Class<T> modelType,
			int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
