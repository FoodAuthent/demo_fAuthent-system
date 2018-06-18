package org.foodauthent.internal.api.persistence;

import org.foodauthent.model.PersistenceIdProvider;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
public class Blob implements PersistenceIdProvider {

    private final DataMetaData metadata;

    private byte[] data;

    private long persistenceId;

    public Blob(final DataMetaData metadata) {
	this(metadata, null);
    }

    public Blob(final DataMetaData metadata, final byte[] data) {
	super();
	this.metadata = metadata;
	this.data = data;
    }

    public byte[] getData() {
	return data;
    }

    public DataMetaData getMetadata() {
	return metadata;
    }

    @Override
    public long getPersistenceId() {
	return persistenceId;
    }

    public void setData(final byte[] data) {
	this.data = data;
    }

    @Override
    public void setPersisenceId(final long persistenceId) {
	this.persistenceId = persistenceId;

    }

    public void setPersistenceId(final long persistenceId) {
	this.persistenceId = persistenceId;
    }

}
