package org.foodauthent.impl.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.foodauthent.api.FileService;
import org.foodauthent.api.internal.exception.FARuntimeException;
import org.foodauthent.api.internal.exception.ServiceNotAvailableException;
import org.foodauthent.api.internal.filereader.RawFileReader;
import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.common.exception.FAExceptions;
import org.foodauthent.common.exception.FAExceptions.InvalidDataException;
import org.foodauthent.common.exception.FAExceptions.InvalidInputException;
import org.foodauthent.model.FaObjectSet;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.FileMetadata.TypeEnum;
import org.foodauthent.model.FilePageResult;
import org.foodauthent.model.ImportResult;
import org.foodauthent.model.Model;
import org.foodauthent.model.ModelPageResult;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
@Component(service = FileService.class)
public class FileServiceImpl implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

    @Reference
    private RawFileReader rawFileReader;

    public FileServiceImpl() {
    }

    @Override
    public UUID createFileMetadata(FileMetadata fileMetadata) {
	if (persistenceService == null) {
	    throw new ServiceNotAvailableException("Persistence service not available");
	}
	persistenceService.save(fileMetadata);
	return fileMetadata.getFaId();
    }

    @Override
    public File getFileData(UUID fileId) {
	Blob blob = persistenceService.getBlobByUUID(fileId);
	try {
	    Path path = Files.createTempFile("file", null);
	    Files.copy(blob.getData(), path);
	    return path.toFile();
	} catch (IOException e) {
	    return null;
	}
    }

    @Override
    public UUID saveFileData(UUID fileId, InputStream upfile, FormDataContentDisposition upfileDetail)
	    throws InvalidDataException, InvalidInputException {
	// TODO it should be possible to store multiple files per UUID, e.g. multiple
	// versions or a data set
	if (persistenceService == null) {
	    throw new ServiceNotAvailableException("Persistence service not available");
	}
	FileMetadata fileMeta = persistenceService.getFaModelByUUID(fileId, FileMetadata.class);
	if (fileMeta == null) {
	    throw new FAExceptions.InvalidInputException("No metadata found for " + fileId);
	}

	validateFileType(fileMeta.getType(), upfileDetail);

	fileMeta = FileMetadata.builder(fileMeta).setUploadName(upfileDetail.getFileName())
		.setUploadDate(LocalDate.now()).build();

	try {
	    if (TypeEnum.FINGERPRINT_BRUKER.equals(fileMeta.getType())) {
		fileMeta = updateFinterprintMetadata(fileMeta, upfile);
	    }

	    persistenceService.replace(fileMeta);

	    // new uuid for the blob (the same id as the one of metadata!)
	    persistenceService.save(new Blob(fileId, upfile));

	    return fileId;
	} catch (Exception e) {
	    throw new FARuntimeException(e);
	}
    }

    private void validateFileType(TypeEnum type, FormDataContentDisposition upfile) throws InvalidDataException {
	switch (type) {
	case KNIME_WORKFLOW:
	    if (!upfile.getFileName().endsWith(".knwf")) {
		throw new FAExceptions.InvalidDataException(
			"Uploaded file probably not a KNIME workflow. Doesn't have a '.knwf' extension.");
	    }
	    break;
	case FINGERPRINT_BRUKER:
	    // TODO: cannot be validated without actually trying to convert the data. We try
	    // to extract finterprint metadata later, so if that works, all is good, if not,
	    // exception is thrown.
	    break;
	default:
	}
    }

    private static byte[] toByteArray(InputStream in) throws IOException {
	// would be cool to be able to use apache's IOUtils
	ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	int nRead;
	byte[] data = new byte[1024];
	while ((nRead = in.read(data, 0, data.length)) != -1) {
	    buffer.write(data, 0, nRead);
	}

	buffer.flush();
	return buffer.toByteArray();
    }

    private FileMetadata updateFinterprintMetadata(FileMetadata fileMeta, InputStream upfile) throws IOException {
	if (rawFileReader == null) {
	    throw new IllegalStateException("Raw file reader is not available");
	}
	Path tmpFile = Files.createTempFile("rawfile-tmp", ".tmp");
	Map<String, String> metaMap = rawFileReader.getAllFileMetadata(fileMeta.getType(), tmpFile.toFile());
	Map<String, String> tmpMap = new LinkedHashMap<>(fileMeta.getAdditionalProperties());
	tmpMap.putAll(metaMap);
	return FileMetadata.builder(fileMeta).setAdditionalProperties(tmpMap).build();

    }

    @Override
    public FileMetadata getFileMetadata(UUID fileId) {
	return persistenceService.getFaModelByUUID(fileId, FileMetadata.class);
    }
    
    @Override
    public void removeFileMetadataAndData(UUID fileId) {
	//remove data
	persistenceService.removeBlobByUUID(fileId);
	//remove metadata
	persistenceService.removeFaModelByUUID(fileId);
    }

    @Override
    public ImportResult importFile(UUID fileId) {

	FileMetadata fileMeta = new FileServiceImpl().getFileMetadata(fileId);

	Importer importer;
	if (fileMeta.getType() == FileMetadata.TypeEnum.ZIP) {
	    importer = new ZipImporter(persistenceService);
	} else if (fileMeta.getType() == FileMetadata.TypeEnum.FAKX) {
	    importer = new FakxImporter(persistenceService);
	} else {
	    return null;
	}

	InputStream stream = persistenceService.getBlobByUUID(fileId).getData();
	FaObjectSet importedObjects = importer.importData(stream);
	ImportResult result = ImportResult.builder().setImportedObjects(importedObjects).build();

	return result;
    }

    @Override
    public File exportFile(String fileType, FaObjectSet faObjectSet) {

	Exporter exporter;
	if (fileType.equals("zip")) {
	    exporter = new ZipExporter(persistenceService);
	} else if (fileType.equals("fakx")) {
	    exporter = new FakxExporter(persistenceService);
	} else {
	    return null;
	}

	try {
	    File file = File.createTempFile("file", ".zip");
	    exporter.export(faObjectSet, file);
	    return file;
	} catch (IOException e) {
	    return null;
	}
    }

    @Override
    public FilePageResult getAllFiles(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<FileMetadata> res = persistenceService.findByKeywordsPaged(FileMetadata.class, pageNumber, pageSize,
		PersistenceService.toArray(keywords));
	return FilePageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }
    
}
