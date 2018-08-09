package org.foodauthent.impl.openchrom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.eclipse.chemclipse.nmr.converter.core.ScanConverterNMR;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.foodauthent.api.internal.filereader.RawFileReader;
import org.foodauthent.model.FileMetadata;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = RawFileReader.class)
public class OpenChromRawFileReader implements RawFileReader {

	private static final Logger logger = LoggerFactory.getLogger(OpenChromRawFileReader.class);

	private static final byte[] buffer = new byte[1024];

	public OpenChromRawFileReader() {

	}

	@Override
	public Map<String, String> getAllFileMetadata(FileMetadata.TypeEnum fileType, FileInputStream stream) throws IOException {

		Map<String, String> result = new LinkedHashMap<>();
		
		File tmpFile = File.createTempFile(getClass().getSimpleName(), null);
		FileUtils.copyInputStreamToFile(stream, tmpFile);
		final Path tmpDir = Files.createTempDirectory(getClass().getSimpleName());
		@SuppressWarnings("resource")
		ZipFile zipFile = new ZipFile(tmpFile);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while(entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			File entryDestination = new File(tmpDir.toFile(), entry.getName());
			System.err.println(entryDestination);
			if(entry.isDirectory()) {
				entryDestination.mkdirs();
			} else {
				entryDestination.getParentFile().mkdirs();
				InputStream in = zipFile.getInputStream(entry);
				OutputStream out = new FileOutputStream(entryDestination);
				IOUtils.copy(in, out);
				IOUtils.closeQuietly(in);
				out.close();
			}
		}

		switch(fileType) {
			case FINGERPRINTS_BRUKER:
				result.putAll(readBruker(tmpDir.toFile()));
				break;
			default:
				throw new RuntimeException();
		}

		return result;
		
	}

	private Map<String, String> readBruker(File file) {

		if(logger.isDebugEnabled()) {
			logger.debug("Reading " + file.getName() + ", " + Arrays.asList(file.list()));
		}
		Map<String, String> result = new LinkedHashMap<>();
		final IProcessingInfo nmr = ScanConverterNMR.convert(file, new NullProgressMonitor());
		System.err.println(nmr.getProcessingResult());

		return result;

	}
}
