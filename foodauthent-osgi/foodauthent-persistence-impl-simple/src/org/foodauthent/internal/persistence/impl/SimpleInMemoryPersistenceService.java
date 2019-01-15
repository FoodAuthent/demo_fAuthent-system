package org.foodauthent.internal.persistence.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.foodauthent.api.internal.exception.EntityExistsException;
import org.foodauthent.api.internal.exception.NoSuchIDException;
import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.model.FaModel;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;
import org.foodauthent.model.Workflow;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@Component(service = PersistenceService.class)
public class SimpleInMemoryPersistenceService implements PersistenceService {

	private static final Logger logger = LoggerFactory.getLogger(SimpleInMemoryPersistenceService.class);

	/**
	 * The class should be a singleton anyways, therefore this is not static.
	 */
	private long persistenceIdCounter = 1;

	/**
	 * Mimics a database and/ or a file system.
	 */
	private final Map<UUID, FaModel> entities;

	private final Map<UUID, Blob> blobs;

	public SimpleInMemoryPersistenceService() {
		this.entities = new LinkedHashMap<UUID, FaModel>();
		this.blobs = new LinkedHashMap<UUID, Blob>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends FaModel> List<T> findByKeywords(final Collection<String> keywords, final Class<T> modelType) {
		final List<T> result = new ArrayList<>();

		if (logger.isDebugEnabled()) {
			logger.debug("Seaching fields: name, descrption");
		}

		for (final Object o : entities.values()) {

			if (modelType.equals(Workflow.class) && o instanceof Workflow) {
				final Workflow wf = (Workflow) o;
				if (keywords.isEmpty() || containsAKeyword(wf.getDescription(), keywords)
						|| containsAKeyword(wf.getName(), keywords)) {
					result.add((T) wf);
				} else {
					if (logger.isDebugEnabled()) {
						logger.debug("Ignoring " + o);
					}
				}
			} else if (modelType.equals(SOP.class) && o instanceof SOP) {
				final SOP sop = (SOP) o;
				if (keywords.isEmpty() || containsAKeyword(sop.getDescription(), keywords)
						|| containsAKeyword(sop.getName(), keywords)) {
					result.add((T) sop);
				}
			} else if (modelType.equals(FingerprintSet.class) && o instanceof FingerprintSet) {
				final FingerprintSet fs = (FingerprintSet) o;
				if (keywords.isEmpty() || containsAKeyword(fs.getName(), keywords)) {
					result.add((T) fs);
				}
			} else if (modelType.equals(Product.class) && o instanceof Product) {
				final Product p = (Product) o;
				if (keywords.isEmpty() || containsAKeyword(p.getBrand(), keywords)) {
					result.add((T) p);
				}
			} else if (modelType.equals(Model.class) && o instanceof Model) {
				final Model m = (Model) o;
				if (keywords.isEmpty() || containsAKeyword(m.getDescription(), keywords)
						|| containsAKeyword(m.getName(), keywords)) {
					result.add((T) m);
				}
			} else {
				if (logger.isDebugEnabled()) {
					logger.debug("Ignoring " + o);
				}
			}
		}
		return result;
	}

	@Override
	public <T extends FaModel> ResultPage<T> findByKeywordsPaged(Collection<String> keywords, Class<T> modelType,
			int pageNumber, int pageSize) {
		List<T> res = findByKeywords(keywords, modelType);
//		Please don't override otherwise the research and paginations doesn't work
//		int start = pageNumber * pageSize;
		int start = (pageNumber-1) * pageSize;
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

	@Override
	public Product findProductByGtin(final String gtin) {
		for (final Object o : entities.values()) {
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
	public <T extends FaModel> T getFaModelByUUID(final UUID uuid, Class<T> modelType) throws NoSuchElementException {
		try {
			return (T) entities.get(uuid);
		} catch (final NoSuchIDException e) {
			throw new NoSuchElementException(e.getLocalizedMessage());
		}
	}

	@Override
	public void removeFaModelByUUID(UUID uuid, Class<?> modelType) {
		entities.remove(uuid);
	}

	/**
	 * Returns the last used entity ID.
	 *
	 * @return the last used entity ID
	 */
	protected long getLastPersistenceId() {
		return persistenceIdCounter;
	}

	@Override
	public UUID save(final Blob blob) throws EntityExistsException {
		save(blob, blob.getFaId());
		return blob.getFaId();
	}

	@Override
	public <T extends FaModel> T save(final T entity) throws EntityExistsException {
		save(entity, entity.getFaId());
		return entity;
	}

	private <T extends Object> boolean save(final T obj, UUID faId) throws EntityExistsException {
		if (obj instanceof FaModel) {
			if (entities.containsKey(faId)) {
				throw new EntityExistsException("An entity with the given id already exists.");
			}
			entities.put(faId, (FaModel) obj);
		} else if (obj instanceof Blob) {
			if (blobs.containsKey(faId)) {
				throw new EntityExistsException("A blob with the given id already exists.");
			}
			blobs.put(faId, (Blob) obj);
		} else {
			throw new IllegalArgumentException("Objects of type '" + obj.getClass().getSimpleName()
					+ "' + not supported by the persistence service.");
		}
		return true;
	}

	@Override
	public <T extends FaModel> T replace(final T entity) throws NoSuchElementException {
		if (!entities.containsKey(entity.getFaId())) {
			throw new NoSuchElementException("No entity to replace for the given fa-id.");
		}
		entities.replace(entity.getFaId(), entity);
		return entity;
	}

	@Override
	public Blob getBlobByUUID(UUID uuid) {
		try {
			return blobs.get(uuid);
		} catch (final NoSuchIDException e) {
			throw new NoSuchElementException(e.getLocalizedMessage());
		}
	}

	/**
	 * 
	 * @param key
	 * @param keywords
	 * @return Check if there is a match for a keyword list
	 */	
	public boolean containsAKeyword(String key, Collection<String> keywords) {
		//Remove empty keywords
		keywords.removeIf(item -> item == null || "".equals(item));
		//check for matching
		if (keywords.stream().map(s -> s.toLowerCase()).anyMatch(key.toLowerCase()::contains)) {
			return true;
		} else {
			return false;
		}
	}

}
