/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import java.io.File;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.ImportResult;

import org.foodauthent.api.FileService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.FileRestService;

import org.foodauthent.common.exception.FAExceptions;

/**
 * FoodAuthent Swagger API
 *
 * <p>This is the FoodAuthent API Description [www.foodauthent.net]
 *
 * <p> 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
@Component(service = FileRestService.class, immediate = true)
public class FileRestServiceImpl implements FileRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private FileService service;


    /**
     * Creates a new file by posting the file metadata first.
     *
     * @param fileMetadata The actual metadata object.
     * @return the response
     */
    public Response createFileMetadata(FileMetadata fileMetadata) {
        
            Object res = service.createFileMetadata(fileMetadata);
            return Response.ok(res).build();
    }

    /**
     * Let one download the actual file data.
     *
     * @param fileId 
     * @return the response
     */
    public Response getFileData(java.util.UUID fileId) {
        
            Object res = service.getFileData(fileId);
            return Response.ok(res).build();
    }

    /**
     * Returns the file metadata.
     *
     * @param fileId 
     * @return the response
     */
    public Response getFileMetadata(java.util.UUID fileId) {
        
            Object res = service.getFileMetadata(fileId);
            return Response.ok(res).build();
    }

    /**
     * Import FoodAuthent components from an existing ZIP file and return the ids of the components.
     *
     * @param fileId 
     * @return the response
     */
    public Response importFile(java.util.UUID fileId) {
        
            Object res = service.importFile(fileId);
            return Response.ok(res).build();
    }

    /**
     * Uploads (and replaces) the actual file-data for the given file id
     *
     * @param fileId 
     * @param filedata The binary file data.
     * @return the response
     */
    public Response saveFileData(java.util.UUID fileId, java.io.InputStream filedata, org.glassfish.jersey.media.multipart.FormDataContentDisposition filedataDetail) {
        try { 
            Object res = service.saveFileData(fileId, filedata, filedataDetail);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.InvalidDataException e) {
           return Response.status(433).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.InvalidInputException e) {
           return Response.status(434).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }
}

