package org.foodauthent.internal.api.persistence;

import java.util.UUID;

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

    private UUID faId;

    public Blob(UUID faId, final DataMetaData metadata) {
	this(faId, metadata, null);
	this.faId = faId;
    }

    public Blob(UUID faId, final DataMetaData metadata, final byte[] data) {
	super();
	this.faId = faId;
	this.metadata = metadata;
	this.data = data;
    }

    public UUID getFaId() {
	return faId;
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
