package org.foodauthent.api.internal.filereader;

import java.util.Map;
import java.util.UUID;

public interface FileReader {

	public Map<String, String> getAllFileMetadata(UUID fileId);
}
