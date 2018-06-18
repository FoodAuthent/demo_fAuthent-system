package org.foodauthent.model;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
public interface PersistenceIdProvider {

    long getPersistenceId();

    void setPersisenceId(long persistenceId);

}
