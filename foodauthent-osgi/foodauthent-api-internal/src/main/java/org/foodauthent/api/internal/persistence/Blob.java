package org.foodauthent.api.internal.persistence;

import java.util.UUID;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
public class Blob  {

    private byte[] data;

    private UUID faId;

    public Blob(UUID faId, final byte[] data) {
	super();
	this.faId = faId;
	this.data = data;
    }

    public UUID getFaId() {
	return faId;
    }

    public byte[] getData() {
	return data;
    }

    public void setData(final byte[] data) {
	this.data = data;
    }

}
