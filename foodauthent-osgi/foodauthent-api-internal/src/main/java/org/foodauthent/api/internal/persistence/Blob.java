package org.foodauthent.api.internal.persistence;

import java.io.InputStream;
import java.util.UUID;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
public class Blob {

	private InputStream data;

	private UUID faId;

	public Blob(UUID faId, final InputStream data) {
		super();
		this.faId = faId;
		this.data = data;
	}

	public UUID getFaId() {
		return faId;
	}

	public InputStream getData() {
		return data;
	}
}
