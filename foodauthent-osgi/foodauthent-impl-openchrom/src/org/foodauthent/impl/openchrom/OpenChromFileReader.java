package org.foodauthent.impl.openchrom;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.foodauthent.api.FileService;
import org.foodauthent.api.internal.filereader.FileReader;
import org.foodauthent.model.FileMetadata;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = FileReader.class)
public class OpenChromFileReader implements FileReader {

	private FileService fileService;

	public FileService getFileService() {

		return fileService;
	}

	@Reference
	public void setFileService(FileService fileService) {

		this.fileService = fileService;
	}

	public OpenChromFileReader() {

	}

	@Override
	public Map<String, String> getAllFileMetadata(UUID fileId) {


		FileMetadata metadata = fileService.getFileMetadata(fileId);
		switch(metadata.getType()) {
			case FINGERPRINTS_BRUKER:
				return readBruker(fileId);
			default:
				throw new RuntimeException();
		}
	}

	private Map<String, String> readBruker(UUID fileId) {

		Map<String, String> result = new LinkedHashMap<>();
		File blob = fileService.getFileData(fileId);
		return result;

	}
}
