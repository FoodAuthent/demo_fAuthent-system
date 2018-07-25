package org.foodauthent.internal.api.persistence;

import java.util.UUID;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
public class Blob {

    private final DataMetaData metadata;

    private byte[] data;

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

    public void setData(final byte[] data) {
	this.data = data;
    }
}
