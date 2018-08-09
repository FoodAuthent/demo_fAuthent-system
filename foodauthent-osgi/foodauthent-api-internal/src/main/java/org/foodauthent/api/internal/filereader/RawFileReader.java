package org.foodauthent.api.internal.filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.foodauthent.model.FileMetadata;

public interface RawFileReader {

	public Map<String, String> getAllFileMetadata(FileMetadata.TypeEnum fileType, File file) throws IOException;

	public Map<String, String> getAllFileMetadata(FileMetadata.TypeEnum fileType, FileInputStream stream) throws IOException;
}
