/*
 * TODO	
 */
package org.foodauthent.api;

import java.io.File;
import org.foodauthent.model.FileMetadata;

import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FileService {

    /**
     * TODO
     *
     * @param fileMetadata The actual metadata object.
     *
     * @return the result
     */
    java.util.UUID createFileMetadata(FileMetadata fileMetadata);
        
    /**
     * TODO
     *
     * @param fileId 
     *
     * @return the result
     */
    File getFileData(java.util.UUID fileId);
        
    /**
     * TODO
     *
     * @param fileId 
     *
     * @return the result
     */
    FileMetadata getFileMetadata(java.util.UUID fileId);
        
    /**
     * TODO
     *
     * @param fileId 
     * @param upfile The file to upload.
     *
     * @return the result
     * @throws InvalidDataException Invalid data was uploaded.
     */
    java.util.UUID saveFileData(java.util.UUID fileId, java.io.InputStream upfile, org.glassfish.jersey.media.multipart.FormDataContentDisposition upfileDetail) throws FAExceptions.InvalidDataException;
        
}
