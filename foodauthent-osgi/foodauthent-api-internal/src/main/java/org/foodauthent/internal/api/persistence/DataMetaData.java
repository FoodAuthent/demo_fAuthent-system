package org.foodauthent.internal.api.persistence;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
public class DataMetaData {

    private final String fileName;

    public DataMetaData(String fileName) {
	this.fileName = fileName;
    }

    public String getFileName() {
	return fileName;
    }

}
