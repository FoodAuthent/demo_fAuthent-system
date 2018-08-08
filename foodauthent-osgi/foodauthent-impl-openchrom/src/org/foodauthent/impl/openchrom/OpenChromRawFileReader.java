package org.foodauthent.impl.openchrom;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.foodauthent.api.internal.filereader.RawFileReader;
import org.foodauthent.model.FileMetadata;
import org.osgi.service.component.annotations.Component;

@Component(service = RawFileReader.class)
public class OpenChromRawFileReader implements RawFileReader {


	public OpenChromRawFileReader() {

	}

	@Override
	public Map<String, String> getAllFileMetadata(FileMetadata.TypeEnum fileType, FileInputStream stream) {

		switch(fileType) {
			case FINGERPRINTS_BRUKER:
				return readBruker(stream);
			default:
				throw new RuntimeException();
		}



	}

	private Map<String, String> readBruker(FileInputStream stream) {

		Map<String, String> result = new LinkedHashMap<>();

		return result;

	}
}
