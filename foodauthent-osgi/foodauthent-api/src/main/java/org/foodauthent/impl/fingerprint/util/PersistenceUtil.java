package org.foodauthent.impl.fingerprint.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.foodauthent.internal.api.persistence.Blob;
import org.foodauthent.internal.api.persistence.DataMetaData;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

/**
 * Utility methods for persistence.
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public class PersistenceUtil {
    
    private PersistenceUtil() {
	//utility class
    }
    
    public static UUID saveBlob(InputStream upfile, FormDataContentDisposition upfileDetail,
	    PersistenceService persistenceService) {
	// TODO check whether there is already a workflow-model entry for the workflow
	// id - otherwise refuse the request
	// TODO it should be possible to store multiple files per UUID, e.g. multiple
	// versions or a data set

	try {
	    // new uuid for the blob
	    UUID blobId = UUID.randomUUID();
	    persistenceService
		    .save(new Blob(blobId, new DataMetaData(upfileDetail.getFileName()), toByteArray(upfile)));
	    return blobId;
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
