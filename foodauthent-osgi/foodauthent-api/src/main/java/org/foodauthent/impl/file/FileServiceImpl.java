package org.foodauthent.impl.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.UUID;

import org.foodauthent.api.FileService;
import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.common.exception.FAExceptions;
import org.foodauthent.common.exception.FAExceptions.InvalidDataException;
import org.foodauthent.common.exception.FAExceptions.InvalidInputException;
import org.foodauthent.common.exception.FARuntimeException;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.FileMetadata.TypeEnum;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
@Component(service=FileService.class)
public class FileServiceImpl implements FileService {
    
    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    private PersistenceService persistenceService;

    public FileServiceImpl() {
    }

    @Reference
    void setPersistenceService(PersistenceService persistenceService) {
	this.persistenceService = persistenceService;
    }
    @Override
    public UUID createFileMetadata(FileMetadata fileMetadata) {
	if (logger.isDebugEnabled()) {
	    logger.debug("Persisting file metadata " + fileMetadata);
	}
	persistenceService.save(fileMetadata);
	return fileMetadata.getFaId();
    }

    @Override
    public File getFileData(UUID fileId) {
	Blob blob = persistenceService.getBlobByUUID(fileId);
	//TODO
	return null;
    }

    @Override
    public UUID saveFileData(UUID fileId, InputStream upfile, FormDataContentDisposition upfileDetail)
	    throws InvalidDataException, InvalidInputException {
	// TODO it should be possible to store multiple files per UUID, e.g. multiple
	// versions or a data set
	
	FileMetadata fileMeta = persistenceService.getFaModelByUUID(fileId, FileMetadata.class);
	if (fileMeta == null) {
	    throw new FAExceptions.InvalidInputException("No metadata found for " + fileId);
	}

	validateFileType(fileMeta.getType(), upfileDetail);

	//update file metadata (metadata must exist! - TODO otherwise throw appropriate exception)
	fileMeta = FileMetadata.builder(fileMeta).setUploadName(upfileDetail.getFileName()).setUploadDate(LocalDate.now()).build();
	persistenceService.replace(fileMeta);

	try {
	    // new uuid for the blob
	    persistenceService
		    .save(new Blob(fileId, toByteArray(upfile)));
	    return fileId;
	} catch (IOException e) {
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
	case FINGERPRINTS_BRUKER:
	    // TODO: cannot be validated without acutally trying to convert the data.
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

    @Override
    public FileMetadata getFileMetadata(UUID fileId) {
	return persistenceService.getFaModelByUUID(fileId, FileMetadata.class);
    }



}
