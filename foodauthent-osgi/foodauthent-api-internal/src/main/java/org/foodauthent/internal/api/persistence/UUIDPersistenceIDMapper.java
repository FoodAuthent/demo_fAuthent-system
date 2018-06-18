package org.foodauthent.internal.api.persistence;

import java.util.UUID;

import org.foodauthent.api.internal.exeption.NoSuchIDException;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
public interface UUIDPersistenceIDMapper {

    long getPersistenceId(UUID uuid) throws NoSuchIDException;

    UUID getUuid(long persistenceId) throws NoSuchIDException;

    void addMapping(UUID uuid, long persistenceId);

}
