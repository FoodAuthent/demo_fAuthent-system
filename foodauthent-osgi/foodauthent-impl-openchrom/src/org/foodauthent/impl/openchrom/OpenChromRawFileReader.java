package org.foodauthent.impl.openchrom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
	public Map<String, String> getAllFileMetadata(FileMetadata.TypeEnum fileType, File file) throws IOException {

		if(!file.exists()) {
			throw new FileNotFoundException(file.toString());
		}
		if(logger.isDebugEnabled()) {
			logger.debug("Reading metadata from " + file);
		}

		Map<String, String> result = new LinkedHashMap<>();
		switch(fileType) {
			case FINGERPRINTS_BRUKER:
				result.putAll(readBruker(file));
				break;
			default:
				throw new RuntimeException();
		}

		return result;
	}

	private void extractFileFromArchive(ZipInputStream stream, File outpath) throws IOException {

		try (FileOutputStream output = new FileOutputStream(outpath)) {
			int len;
			while((len = stream.read(buffer)) > 0) {
				output.write(buffer, 0, len);
			}
		}
	}

	@Override
	public Map<String, String> getAllFileMetadata(FileMetadata.TypeEnum fileType, FileInputStream stream2) throws IOException {

		ZipInputStream stream = new ZipInputStream(stream2);
		Path tmpDir = Files.createTempDirectory(getClass().getSimpleName());

		if(logger.isDebugEnabled()) {
			logger.debug("Extracting to tmp dir " + tmpDir);
		}
		ZipEntry entry;
		while((entry = stream.getNextEntry()) != null) {
			if(entry.isDirectory()) {
				if(new File(tmpDir.toFile(), entry.getName()).mkdirs()) {
				}
				else {
					throw new IOException("Failed to create directory " + entry.getName());
				}
			} else {
				File outFile = new File(tmpDir.toFile(), entry.getName());
				extractFileFromArchive(stream, outFile);
			}
		}

		return getAllFileMetadata(fileType, new File(tmpDir.toFile(), "fid"));
		
	}

	private Map<String, String> readBruker(File file) {

		if(logger.isDebugEnabled()) {
			logger.debug("Reading " + file.getName());
		}
		Map<String, String> result = new LinkedHashMap<>();
		final IProcessingInfo processingInfo = ScanConverterNMR.convert(file, new NullProgressMonitor());
		if(processingInfo == null) {
			if(logger.isErrorEnabled()) {
				logger.error("Processing failed");
			}
		} else {
			Object processingResult = processingInfo.getProcessingResult();
			System.err.println(processingResult.getClass());
			/*
			if(processingResult instanceof IVendorScaNMR) {
				IVendorScanNMR scan = (IVendorScanNMW)processingResult;
				result.putAll(scan.getHeaderDataMap());
			} else {
				if(logger.isErrorEnabled()) {
					logger.error("Processing failed");
				}
			}
			*/
		}

		return result;

	}
}
