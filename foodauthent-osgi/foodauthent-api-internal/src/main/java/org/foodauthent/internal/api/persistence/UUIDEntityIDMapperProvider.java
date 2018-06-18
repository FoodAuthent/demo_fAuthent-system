package org.foodauthent.internal.api.persistence;

/**
 * A global static venue to retrieve a singleton instance of
 * {@link UUIDEntityIDMapperProvider}.
 * <p>
 * Will be replaced by the OSGi Service Registry.
 * </p>
 *
 * * @author Alexander Kerner, Lablicate GmbH
 *
 */
public class UUIDEntityIDMapperProvider {

    private static class InstanceHolder {
	private static final UUIDEntityIDMapperProvider instance = new UUIDEntityIDMapperProvider();
    }

    public static UUIDEntityIDMapperProvider getInstance() {
	return InstanceHolder.instance;
    }

    private final UUIDPersistenceIDMapper mapper;

    private UUIDEntityIDMapperProvider() {
	this.mapper = new SimpleUUIDEntityMapper();
    }

    public UUIDPersistenceIDMapper getEntityMapper() {
	return mapper;
    }

}
