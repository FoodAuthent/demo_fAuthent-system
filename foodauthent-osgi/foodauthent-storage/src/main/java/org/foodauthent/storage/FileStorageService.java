package org.foodauthent.storage;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public interface FileStorageService {

	public void save(UUID id, InputStream in) throws IOException;
	
	public void save(UUID id, InputStream in, String contentType) throws IOException;

	public InputStream load(UUID id) throws IOException;

	public boolean delete(UUID id) throws IOException;
	
	public boolean exists(UUID id) throws IOException;
}
