package org.foodauthent.api.internal.persistence;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.foodauthent.api.internal.exception.ModelExistsException;
import org.foodauthent.model.FaModel;
import org.foodauthent.model.Product;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;

@Component(service = PersistenceService.class, immediate = true)
public class PersistenceServiceProviderProxy implements PersistenceService {

	private PersistenceServiceProvider provider;

	private final List<PersistenceServiceProvider> providers = new ArrayList<>();

	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceServiceProviderProxy.class);

	@Reference(service = PersistenceServiceProvider.class, policy = ReferencePolicy.DYNAMIC, //
			cardinality = ReferenceCardinality.AT_LEAST_ONE, unbind = "unbindPersistenceServiceProvider")
	public void bindPersistenceServiceProvider(PersistenceServiceProvider persistenceServiceProvider) {
		LOGGER.info(String.format("adding PersistenceServiceProvider class %s",
				persistenceServiceProvider.getClass().getSimpleName()));
		providers.add(persistenceServiceProvider);
		providers.sort(new Comparator<PersistenceServiceProvider>() {

			@Override
			public int compare(PersistenceServiceProvider o1, PersistenceServiceProvider o2) {
				return Integer.compare(o2.getPriority(), o1.getPriority());
			}
		});
		this.provider = providers.get(0);
		LOGGER.info(String.format("using PersistenceServiceProvider class %s", provider.getClass().getSimpleName()));
	}

	public void unbindPersistenceServiceProvider(PersistenceServiceProvider persistenceServiceProvider) {
		providers.remove(persistenceServiceProvider);
		if (providers.isEmpty()) {
			this.provider = null;
		} else {
			this.provider = providers.get(0);
		}
	}

	public int getPriority() {
		return provider.getPriority();
	}

	public <T extends FaModel> T save(T model) throws ModelExistsException {
		return provider.save(model);
	}

	public <T extends FaModel> T replace(T model) throws NoSuchElementException {
		return provider.replace(model);
	}

	public UUID save(Blob blob) throws ModelExistsException {
		return provider.save(blob);
	}

	public Product findProductByGtin(String gtin) {
		return provider.findProductByGtin(gtin);
	}
	
	@Override
	public Product getProductById(UUID id) {
		return provider.getProductById(id);
	}

	public <T extends FaModel> T getFaModelByUUID(UUID uuid, Class<T> modelType) {
		return provider.getFaModelByUUID(uuid, modelType);
	}

	@Override
	public void removeFaModelByUUID(UUID uuid) throws NoSuchElementException {
		provider.removeFaModelByUUID(uuid);
	}
	
	@Override
	public void removeBlobByUUID(UUID uuid) {
		provider.removeBlobByUUID(uuid);
	}

	public <T extends FaModel> List<T> findByKeywords(Class<T> modelType, String[]... keywordSuperSet) {
		return provider.findByKeywords(modelType, keywordSuperSet);
	}

	public <T extends FaModel> ResultPage<T> findByKeywordsPaged(Class<T> modelType, int pageNumber, int pageSize,
			String[]... keywordSuperSet) {
		return provider.findByKeywordsPaged(modelType, pageNumber, pageSize, keywordSuperSet);
	}

	public Blob getBlobByUUID(UUID uuid) {
		return provider.getBlobByUUID(uuid);
	}

	public void saveCustomModel(String modelId, String schemaId, UUID uuid, JsonNode model) {
		provider.saveCustomModel(modelId, schemaId, uuid, model);
	}

	public JsonNode getCustomModelByUUID(String modelId, String schemaId, UUID uuid) {
		return provider.getCustomModelByUUID(modelId, schemaId, uuid);
	}

	@Override
	public <T extends FaModel> long getModelCount(Class<T> modelType) {
		return provider.getModelCount(modelType);
	}

	@Override
	public long getBlobCount() {
		return provider.getBlobCount();
	}

	@Override
	public <T extends FaModel> ResultPage<T> findByRelationPaged(Class<T> modelType, int pageNumber, int pageSize,
			String referencedFieldName, UUID faId) {
		return provider.findByRelationPaged(modelType, pageNumber, pageSize, referencedFieldName, faId);
	}

}
