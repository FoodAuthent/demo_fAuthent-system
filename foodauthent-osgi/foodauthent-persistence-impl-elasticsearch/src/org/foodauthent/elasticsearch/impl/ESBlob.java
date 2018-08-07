package org.foodauthent.elasticsearch.impl;

import java.util.Base64;
import java.util.UUID;

import org.foodauthent.api.internal.persistence.Blob;

/**
 * Blob implementation for converting data to required Base64 encoded format
 * Base64 Encoding is required by Elasticsearch to store data as binary 
 *
 * @author Sven Böckelmann
 *
 */
public class ESBlob {

	private String data;

	public ESBlob() {

	}

	public ESBlob(Blob blob) {
		this.data = Base64.getEncoder().encodeToString(blob.getData());
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Blob toBlob(UUID faId) {
		return new Blob(faId, Base64.getDecoder().decode(data));
	}
}
