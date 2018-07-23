package org.foodauthent.elasticsearch.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.apache.http.Header;
import org.elasticsearch.action.index.IndexRequest;
import org.foodauthent.api.internal.exeption.EntityExistsException;
import org.foodauthent.elasticsearch.ClientService;
import org.foodauthent.internal.api.persistence.Blob;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.model.FaModel;
import org.foodauthent.model.Product;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.google.common.io.CharStreams;

import scala.Option;

@Component(service = PersistenceService.class)
public class ElasticsearchPersistenceService implements PersistenceService {

	private ElasticsearchOperation op;

	private Map<Class<?>, Target> targets = new HashMap<Class<?>, Target>();

	@Reference
	public void bindClientService(ClientService clientService) {
		op = new ElasticsearchOperation(clientService.getClient());
	}

	@Override
	public <T extends FaModel> long save(T entity) throws EntityExistsException {
		if (op.save(Option.apply(entity.getFaId().toString()), entity, classTarget(entity.getClass()))) {
			return entity.getFaId().getMostSignificantBits();
		}
		return -1;
	}

	@Override
	public <T extends FaModel> long replace(T entity) throws NoSuchElementException {
		if (op.update(entity.getFaId().toString(), entity, classTarget(entity.getClass()))) {
			return entity.getFaId().getMostSignificantBits();
		}
		return -1;
	}

	@Override
	public long save(Blob blob) throws EntityExistsException {
		Target target = blobTarget();
		IndexRequest request = new IndexRequest(target.indexName(), target.typeName(), blob.getFaId().toString());
		Map<String, String> data = new HashMap<String, String>();
		data.put("blob", Base64.getEncoder().encodeToString(blob.getData()));
		request.source(data);
		try {
			op.client().index(request, new Header[0]);
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		return blob.getFaId().getMostSignificantBits();
	}

	@Override
	public <T extends Product> T findProductByGtin(String gtin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends FaModel> T getFaModelByUUID(UUID uuid, Class<T> modelType) {
		Option<T> value = op.get(uuid.toString(), modelType, classTarget(modelType));
		if (value.isDefined()) {
			return value.get();
		}
		return null;
	}

	@Override
	public <T extends FaModel> List<T> findByKeywords(Collection<String> keywords, Class<T> modelType) {
		return Collections.emptyList();
	}

	@Override
	public Blob getBlobByUUID(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	private Target classTarget(Class<?> cls) {
		Target t = targets.get(cls);
		if (t == null) {
			t = new Target(cls.getSimpleName(), "data");
			targets.put(cls, t);
		}
		return t;
	}

	private Target blobTarget() {
		Target t = targets.get(Blob.class);
		if (t == null) {
			t = new Target(Blob.class.getSimpleName(), "data");
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
	public int getPriority() {
		return 10;
	}

}
