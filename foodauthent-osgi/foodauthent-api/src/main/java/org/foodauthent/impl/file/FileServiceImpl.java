package org.foodauthent.impl.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.foodauthent.api.FileService;
import org.foodauthent.internal.api.persistence.Blob;
import org.foodauthent.internal.api.persistence.DataMetaData;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.FileMetadata;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public class FileServiceImpl implements FileService {
    
    private final PersistenceService persistenceService;

    public FileServiceImpl() {
	this.persistenceService = PersistenceServiceProvider.getInstance().getService();
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
    public FileMetadata getFileMetadata(UUID fileId) {
	return persistenceService.getFaModelByUUID(fileId);
    }

    @Override
    public UUID saveFileData(UUID fileId, InputStream upfile, FormDataContentDisposition upfileDetail) {
	// TODO check whether there is already a workflow-model entry for the workflow
	// id - otherwise refuse the request
	// TODO it should be possible to store multiple files per UUID, e.g. multiple
	// versions or a data set

	try {
	    // new uuid for the blob
	    persistenceService
		    .save(new Blob(fileId, new DataMetaData(upfileDetail.getFileName()), toByteArray(upfile)));
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



}
