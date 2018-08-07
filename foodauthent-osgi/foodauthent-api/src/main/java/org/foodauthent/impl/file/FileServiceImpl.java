package org.foodauthent.impl.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.UUID;

import org.foodauthent.api.FileService;
import org.foodauthent.internal.api.persistence.Blob;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.model.FileMetadata;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
@Component(service=FileService.class)
public class FileServiceImpl implements FileService {
    
    private PersistenceService persistenceService;

    public FileServiceImpl() {
    }
    
    @Reference
    void setPersistenceService(PersistenceService persistenceService) {
	this.persistenceService = persistenceService;
    }
    

    @Override
    public UUID createFileMetadata(FileMetadata fileMetadata) {
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
    public UUID saveFileData(UUID fileId, InputStream upfile, FormDataContentDisposition upfileDetail) {
	// TODO check whether there is already a workflow-model entry for the workflow
	// id - otherwise refuse the request
	// TODO it should be possible to store multiple files per UUID, e.g. multiple
	// versions or a data set
	
	FileMetadata fileMeta = persistenceService.getFaModelByUUID(fileId, FileMetadata.class);

	//basic verification whether the uploaded file type matches the file metadata's type
	// TODO add more logic
	switch (fileMeta.getType()) {
	case KNIME_WORKFLOW:
	    // expecting the uploaded file to end with ".knwf"
	    if (!upfileDetail.getFileName().endsWith(".knwf")) {
		// TODO throw appropriate exception!!
		throw new RuntimeException(
			"Uploaded file probably not a KNIME workflow. Doesn't have a '.knwf' extension.");
	    }
	    break;
	case FINGERPRINTS_BRUKER:
	    // TODO: store original data, or converted data, or both?
	    // data is zipped, just to mention it.
	    break;
	default:
	    // TODO throw appropriate exception!
	    throw new RuntimeException("File of type " + fileMeta.getType() + " not yet supported.");
	}

	//update file metadata (metadata must exist! - TODO otherwise throw appropriate exception)
	fileMeta = FileMetadata.builder(fileMeta).setUploadName(upfileDetail.getFileName()).setUploadDate(LocalDate.now()).build();
	persistenceService.replace(fileMeta);

	try {
	    // new uuid for the blob
	    persistenceService
		    .save(new Blob(fileId, toByteArray(upfile)));
	    return fileId;
	} catch (IOException e) {
	    // TODO throw appropriate exception
	    throw new RuntimeException(e);
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
