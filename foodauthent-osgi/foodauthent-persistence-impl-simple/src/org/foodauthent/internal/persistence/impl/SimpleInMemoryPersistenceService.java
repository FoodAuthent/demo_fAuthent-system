package org.foodauthent.internal.persistence.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.foodauthent.api.internal.exception.ModelExistsException;
import org.foodauthent.api.internal.exception.NoSuchIDException;
import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.api.internal.persistence.PersistenceServiceProvider;
import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.FaModel;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.ObjectEvent;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;
import org.foodauthent.model.Sample;
import org.foodauthent.model.Workflow;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * A simple persistence service, that holds objects in memory.
 * <p>
 * Entity IDs are only unique for the connected database.
 * </p>
 * <p>
 * Once the instance is destroyed, data is lost.
 * </p>
 *
 * @author Alexander Kerner
 *
 */
@Component(service = PersistenceServiceProvider.class)
public class SimpleInMemoryPersistenceService implements PersistenceServiceProvider {

	private static final Logger logger = LoggerFactory.getLogger(SimpleInMemoryPersistenceService.class);

	/**
	 * The class should be a singleton anyways, therefore this is not static.
	 */
	private long persistenceIdCounter = 1;

	/**
	 * Mimics a database and/ or a file system.
	 */
	private final Map<UUID, FaModel> models;

	private final Map<String, JsonNode> customModels;

	private final Map<UUID, byte[]> blobs;
	
	private final Map<Class<?>, ModelPropertiesSupplier<?>> modelPropertiesSupplier;
	
	@SuppressWarnings("unchecked")
	public SimpleInMemoryPersistenceService() {
		this.models = new LinkedHashMap<UUID, FaModel>();
		this.blobs = new LinkedHashMap<UUID, byte[]>();
		this.customModels = new LinkedHashMap<String, JsonNode>();

		List<ModelPropertiesSupplier<?>> tmp = new ArrayList<>();

		tmp.add(createMPS(Workflow.class, m -> m.getDescription(), m -> m.getName()));
		tmp.add(createMPS(SOP.class, m -> m.getDescription(), m -> m.getName()));
		tmp.add(createMPS(Product.class, m -> m.getBrand()));
		tmp.add(createMPS(Model.class, m -> m.getDescription(), m -> m.getName(),
				m -> m.getFingerprintsetIds().stream().map(uuid -> uuid.toString()).collect(Collectors.joining(",")),
				m -> m.getWorkflowId().toString()));
		tmp.add(createMPS(Sample.class, m -> m.getApplication(), m -> m.getSopId().toString(),
				m -> m.getComments().stream().collect(Collectors.joining(","))));
		tmp.add(createMPS(FingerprintSet.class, m -> m.getDescription(), m-> m.getName()));
		tmp.add(createMPS(Prediction.class, m -> m.getModelId().toString(), m -> m.getFingerprintsetId().toString(),
				m -> m.getWorkflowId().toString()));

		tmp.add(createMPS(ObjectEvent.class,
				m -> m.getEpcList().stream().map(e -> e.getEpc()).collect(Collectors.joining(","))));
		tmp.add(createMPS(DiscoveryServiceTransaction.class,
				m -> m.getEpcList().stream().map(e -> e.getEpc()).collect(Collectors.joining(","))));
		
		modelPropertiesSupplier = tmp.stream().collect(Collectors.toMap(mps -> mps.getModelClass(), mps -> mps));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends FaModel> List<T> findByKeywords(final Collection<String> orgKeywords, final Class<T> modelType) {
		if (logger.isDebugEnabled()) {
			logger.debug("Seaching fields: name, descrption");
		}

		Collection<String> keywords = removeEmptyKeywords(orgKeywords);

		List<T> filterByModelType = (List<T>) models.values().stream()
				.filter(m -> modelType.isAssignableFrom(m.getClass())).collect(Collectors.toList());
		if (keywords.isEmpty()) {
			return filterByModelType;
		}

		ModelPropertiesSupplier<T> mps = (ModelPropertiesSupplier<T>) modelPropertiesSupplier.get(modelType);
		return filterByModelType.stream().filter(m -> containsKeywords(keywords, mps.getPropertyValues(m)))
				.collect(Collectors.toList());
	}

	@Override
	public <T extends FaModel> ResultPage<T> findByKeywordsPaged(Collection<String> keywords, Class<T> modelType,
			int pageNumber, int pageSize) {
		List<T> res = findByKeywords(keywords, modelType);
		// Please don't override otherwise the research and paginations doesn't work
		// int start = pageNumber * pageSize;
		int start = (pageNumber - 1) * pageSize;
		List<T> page = res.stream().skip(start).limit(pageSize).collect(Collectors.toList());
		return new ResultPage<T>() {

			@Override
			public int getTotalNumPages() {
				return res.size() / pageSize;
			}

			@Override
			public int getTotalNumEntries() {
				return res.size();
			}

			@Override
			public List<T> getResult() {
				return page;
			}

		};
	}
	
	private static Collection<String> removeEmptyKeywords(Collection<String> keywords) {
		// Remove empty keywords
		return keywords.stream().filter(item -> !(item == null || "".equals(item))).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param key
	 * @param keywords
	 * @return Check if there is a match for a keyword list
	 */
	private static boolean containsAKeyword(String key, Collection<String> keywords) {
		if (key == null) {
			return false;
		}
		// check for matching
		if (keywords.stream().map(s -> s.toLowerCase()).anyMatch(key.toLowerCase()::contains)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean containsKeywords(Collection<String> keywords, Collection<String> propertyValues) {
		return propertyValues.stream().anyMatch(k -> containsAKeyword(k, keywords));
	}

	@Override
	public Product findProductByGtin(final String gtin) {
		for (final Object o : models.values()) {
			if (o instanceof Product) {
				final Product p = (Product) o;
				if (gtin.equals(p.getGtin())) {
					return p;
				}
			}
		}
		throw new NoSuchElementException("No product found for " + gtin);
	}

	@Override
	public Product getProductById(UUID id) {
		return getFaModelByUUID(id, Product.class);
	}

	@Override
	public <T extends FaModel> T getFaModelByUUID(final UUID uuid, Class<T> modelType) throws NoSuchElementException {
		try {
			return (T) models.get(uuid);
		} catch (final NoSuchIDException e) {
			throw new NoSuchElementException(e.getLocalizedMessage());
		}
	}

	@Override
	public void removeFaModelByUUID(UUID uuid, Class<?> modelType) {
		models.remove(uuid);
	}

	/**
	 * Returns the last used model ID.
	 *
	 * @return the last used model ID
	 */
	protected long getLastPersistenceId() {
		return persistenceIdCounter;
	}

	@Override
	public UUID save(final Blob blob) throws ModelExistsException {
		save(blob, blob.getFaId());
		return blob.getFaId();
	}

	@Override
	public <T extends FaModel> T save(final T model) throws ModelExistsException {
		save(model, model.getFaId());
		return model;
	}

	@Override
	public void saveCustomModel(String modelId, String schemaId, UUID uuid, JsonNode model) {
		this.customModels.put(customModelKey(modelId, schemaId, uuid), model);
	}

	@Override
	public JsonNode getCustomModelByUUID(String modelId, String schemaId, UUID uuid) {
		return this.customModels.get(customModelKey(modelId, schemaId, uuid));
	}

	private String customModelKey(String modelId, String schemaId, UUID uuid) {
		return modelId + "-" + schemaId + "-" + uuid.toString();
	}

	private <T extends Object> boolean save(final T obj, UUID faId) throws ModelExistsException {
		if (obj instanceof FaModel) {
			if (models.containsKey(faId)) {
				throw new ModelExistsException("An model with the given id already exists.");
			}
			models.put(faId, (FaModel) obj);
		} else if (obj instanceof Blob) {
			if (blobs.containsKey(faId)) {
				throw new ModelExistsException("A blob with the given id already exists.");
			}
			try {
				blobs.put(faId, IOUtils.toByteArray(((Blob) obj).getData()));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new IllegalArgumentException("Objects of type '" + obj.getClass().getSimpleName()
					+ "' + not supported by the persistence service.");
		}
		return true;
	}

	@Override
	public <T extends FaModel> T replace(final T model) throws NoSuchElementException {
		if (!models.containsKey(model.getFaId())) {
			throw new NoSuchElementException("No model to replace for the given fa-id.");
		}
		models.replace(model.getFaId(), model);
		return model;
	}

	@Override
	public Blob getBlobByUUID(UUID uuid) {
		try {
			return new Blob(uuid, new ByteArrayInputStream(blobs.get(uuid)));
		} catch (final NoSuchIDException e) {
			throw new NoSuchElementException(e.getLocalizedMessage());
		}
	}
	
	@Override
	public int getPriority() {
		return 0;
	}

	@Override
	public <T extends FaModel> long getModelCount(Class<T> modelType) {
		return models.values().stream().filter(m -> modelType.isAssignableFrom(m.getClass())).count();
	}

	@Override
	public long getBlobCount() {
		return blobs.size();
	}
	
	private interface ModelPropertiesSupplier<T extends FaModel> {

		Class<T> getModelClass();

		List<String> getPropertyValues(T model);
	}

	private static <T extends FaModel> ModelPropertiesSupplier<T> createMPS(Class<T> modelClass,
			Function<T, String>... propertySupplier) {
		return new ModelPropertiesSupplier<T>() {

			@Override
			public Class<T> getModelClass() {
				return modelClass;
			}

			@Override
			public List<String> getPropertyValues(T model) {
				return Arrays.stream(propertySupplier).map(ps -> ps.apply((T) model)).collect(Collectors.toList());
			}
		};
	}

}
