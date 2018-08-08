package org.foodauthent.impl.openchrom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.eclipse.chemclipse.nmr.converter.core.ScanConverterNMR;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.foodauthent.api.internal.filereader.RawFileReader;
import org.foodauthent.model.FileMetadata;
import org.osgi.service.component.annotations.Component;

@Component(service = RawFileReader.class)
public class OpenChromRawFileReader implements RawFileReader {

	private static long tmpFileCnt = 0;


	public OpenChromRawFileReader() {

	}

	@Override
	public Map<String, String> getAllFileMetadata(FileMetadata.TypeEnum fileType, FileInputStream stream) throws IOException {

		File file = File.createTempFile(getClass() + "-" + tmpFileCnt, null);
		
		FileUtils.copyInputStreamToFile(stream, file);
		
		switch(fileType) {
			case FINGERPRINTS_BRUKER:
				return readBruker(file);
			default:
				throw new RuntimeException();
		}
	}

	private Map<String, String> readBruker(File file) {

		Map<String, String> result = new LinkedHashMap<>();
		final IProcessingInfo nmr = ScanConverterNMR.convert(file, new NullProgressMonitor());
		System.err.println(nmr.getProcessingResult());

		return result;

	}
}
