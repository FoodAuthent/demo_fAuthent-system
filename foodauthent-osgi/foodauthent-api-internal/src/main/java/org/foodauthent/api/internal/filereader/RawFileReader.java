package org.foodauthent.api.internal.filereader;

import java.io.FileInputStream;
import java.util.Map;

import org.foodauthent.model.FileMetadata;

public interface RawFileReader {

	public Map<String, String> getAllFileMetadata(FileMetadata.TypeEnum fileType, FileInputStream stream);
}
