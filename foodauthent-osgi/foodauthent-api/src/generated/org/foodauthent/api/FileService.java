/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.FaObjectSet;
import java.io.File;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.FilePageResult;
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
     * @param fileId 
     * @param faObjectSet Specifies a set of fa-objects to be exported.
     *
     * @return the result
     */
    File exportFile(String fileType, java.util.UUID fileId, FaObjectSet faObjectSet);
        
    /**
     * Returns the all the files metadata.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    FilePageResult getAllFiles(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
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
     * Removes the file and it&#39;s metadata for the given id
     *
     * @param fileId 
     *
     * 
     */
    void removeFileMetadataAndData(java.util.UUID fileId);
        
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
