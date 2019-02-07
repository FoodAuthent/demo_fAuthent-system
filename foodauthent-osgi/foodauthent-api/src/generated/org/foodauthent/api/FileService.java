/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.FaObjectSet;
import java.io.File;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.ImportResult;

import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FileService {

    /**
     * Creates a new file by posting the file metadata first.
     *
     * @param fileMetadata The actual metadata object.
     *
     * @return the result
     */
    java.util.UUID createFileMetadata(FileMetadata fileMetadata);
        
    /**
     * Export FoodAuthent components
     *
     * @param fileType 
     * @param faObjectSet Specifies a set of fa-objects to be exported.
     *
     * @return the result
     */
    File exportFile(String fileType, FaObjectSet faObjectSet);
        
    /**
     * Let one download the actual file data.
     *
     * @param fileId 
     *
     * @return the result
     */
    File getFileData(java.util.UUID fileId);
        
    /**
     * Returns the file metadata.
     *
     * @param fileId 
     *
     * @return the result
     */
    FileMetadata getFileMetadata(java.util.UUID fileId);
        
    /**
     * Import FoodAuthent components from an existing ZIP file and return the ids of the components.
     *
     * @param fileId 
     *
     * @return the result
     */
    ImportResult importFile(java.util.UUID fileId);
        
    /**
     * Uploads (and replaces) the actual file-data for the given file id
     *
     * @param fileId 
     * @param filedata The binary file data.
     *
     * @return the result
     * @throws InvalidDataException Invalid data was uploaded.
     * @throws InvalidInputException Invalid input was provided.
     * @throws FAException Unspecified exception.
     */
    java.util.UUID saveFileData(java.util.UUID fileId, java.io.InputStream filedata, org.glassfish.jersey.media.multipart.FormDataContentDisposition filedataDetail) throws FAExceptions.InvalidDataException, FAExceptions.InvalidInputException, FAExceptions.FAException;
        
}
