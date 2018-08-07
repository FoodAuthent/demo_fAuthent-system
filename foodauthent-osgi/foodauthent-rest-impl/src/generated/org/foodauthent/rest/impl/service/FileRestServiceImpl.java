/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.io.File;
import org.foodauthent.model.FileMetadata;

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
public class FileRestServiceImpl implements FileRestService {

    private final FileService service = ServiceRegistry.get(FileService.class);


    /**
     * TODO
     *
     * @param fileMetadata The actual metadata object.
     * @return the response
     */
    public Response createFileMetadata(FileMetadata fileMetadata) {
        
            Object res = service.createFileMetadata(fileMetadata);
            return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param fileId 
     * @return the response
     */
    public Response getFileData(java.util.UUID fileId) {
        
            Object res = service.getFileData(fileId);
            return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param fileId 
     * @return the response
     */
    public Response getFileMetadata(java.util.UUID fileId) {
        
            Object res = service.getFileMetadata(fileId);
            return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param fileId 
     * @param upfile The file to upload.
     * @return the response
     */
    public Response saveFileData(java.util.UUID fileId, java.io.InputStream upfile, org.glassfish.jersey.media.multipart.FormDataContentDisposition upfileDetail) {
        try { 
            Object res = service.saveFileData(fileId, upfile, upfileDetail);
            return Response.ok(res).build();
        } catch(FAExceptions.InvalidDataException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }
}

