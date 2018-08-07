package org.foodauthent.elasticsearch.impl;

import java.util.Base64;
import java.util.UUID;

import org.foodauthent.internal.api.persistence.Blob;
import org.foodauthent.internal.api.persistence.DataMetaData;

/**
 * Blob implementation for converting data to required Base64 encoded format
 * Base64 Encoding is required by Elasticsearch to store data as binary 
 *
 * @author Sven Böckelmann
 *
 */
public class ESBlob {

	private String data;

	private DataMetaData dataMetaData;

	public ESBlob() {

	}

	public ESBlob(Blob blob) {
		this.data = Base64.getEncoder().encodeToString(blob.getData());
		this.dataMetaData = blob.getMetadata();
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public DataMetaData getDataMetaData() {
		return dataMetaData;
	}

	public void setDataMetaData(DataMetaData dataMetaData) {
		this.dataMetaData = dataMetaData;
	}
	
	public Blob toBlob(UUID faId) {
		return new Blob(faId, dataMetaData, Base64.getDecoder().decode(data));
	}
}
