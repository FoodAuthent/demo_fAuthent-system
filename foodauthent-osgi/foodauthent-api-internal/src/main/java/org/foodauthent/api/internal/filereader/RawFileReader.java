package org.foodauthent.api.internal.filereader;

import java.util.Map;
import java.util.UUID;

public interface RawFileReader {

	public Map<String, String> getAllFileMetadata(UUID fileId);
}
