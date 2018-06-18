package org.foodauthent.internal.api.persistence;

import org.foodauthent.internal.impl.persistence.SimpleInMemoryPersistenceService;

/**
 * A global static venue to retrieve a singleton instance of
 * {@link PersistenceService}.
 * <p>
 * Will be replaced by the OSGi Service Registry.
 * </p>
 *
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 *
 */
public class PersistenceServiceProvider {

    private static class InstanceHolder {
	private static final PersistenceServiceProvider instance = new PersistenceServiceProvider();
    }

    public static PersistenceServiceProvider getInstance() {
	return InstanceHolder.instance;
    }

    private final PersistenceService persistenceService;

    private PersistenceServiceProvider() {
	this.persistenceService = new SimpleInMemoryPersistenceService();
    }

    public PersistenceService getService() {
	return persistenceService;
    }

}
