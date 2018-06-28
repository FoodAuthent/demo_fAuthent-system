package org.foodauthent.internal.impl.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.foodauthent.api.internal.exeption.NoSuchIDException;
import org.foodauthent.internal.api.persistence.Blob;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.UUIDEntityIDMapperProvider;
import org.foodauthent.internal.api.persistence.UUIDPersistenceIDMapper;
import org.foodauthent.model.FaModel;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.PersistenceIdProvider;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;
import org.foodauthent.model.Workflow;
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
public class SimpleInMemoryPersistenceService implements PersistenceService {

    private static final Logger logger = LoggerFactory.getLogger(SimpleInMemoryPersistenceService.class);

    /**
     * The class should be a singleton anyways, therefore this is not static.
     */
    private long entityIdCounter = 1;

    /**
     * Mimics a database and/ or a file system.
     */
    private final Map<Long, Object> entities;

    private final UUIDPersistenceIDMapper idMapper;

    public SimpleInMemoryPersistenceService() {
	this.entities = new LinkedHashMap<>();
	this.idMapper = UUIDEntityIDMapperProvider.getInstance().getEntityMapper();
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
		if (keywords.contains(wf.getDescription())) {
		    result.add((T) wf);
		}
		if (keywords.contains(wf.getName())) {
		    result.add((T) wf);
		} else {
		    if (logger.isDebugEnabled()) {
			logger.debug("Ignoring " + o);
		    }
		}
	    } else if (modelType.equals(SOP.class) && o instanceof SOP) {
		final SOP sop = (SOP) o;
		if (keywords.contains(sop.getDescription())) {
		    result.add((T) sop);
		}
		if (keywords.contains(sop.getName())) {
		    result.add((T) sop);
		}
	    } else if (modelType.equals(FingerprintSet.class) && o instanceof FingerprintSet) {
		final FingerprintSet fs = (FingerprintSet) o;
		if (keywords.contains(fs.getName())) {
		    result.add((T) fs);
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

    @SuppressWarnings("unchecked")
    @Override
    public <T extends FaModel> T getByUUID(final UUID uuid) throws NoSuchElementException {
	try {
	    final long entityId = idMapper.getPersistenceId(uuid);
	    return (T) entities.get(entityId);
	} catch (final NoSuchIDException e) {
	    throw new NoSuchElementException(e.getLocalizedMessage());
	}
    }

    /**
     * Returns the last used entity ID.
     *
     * @return the last used entity ID
     */
    protected long getLastEntityId() {
	return entityIdCounter;
    }

    @Override
    public long save(final Blob blob) {
	return save((PersistenceIdProvider) blob);
    }

    @Override
    public long save(final FaModel entity) {
	final long currentId = save((PersistenceIdProvider) entity);
	idMapper.addMapping(entity.getFaId(), entity.getPersistenceId());
	return currentId;
    }

    public long save(final PersistenceIdProvider entity) {
	final long currentId = entityIdCounter++;
	final Object oldVal = entities.put(currentId, entity);
	if (oldVal != null && logger.isWarnEnabled()) {
	    logger.warn(oldVal + " replaced");
	}
	entity.setPersisenceId(currentId);
	return currentId;
    }
}