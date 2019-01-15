/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.io.File;
import org.foodauthent.model.FileMetadata;

import org.foodauthent.api.FileService;
import org.foodauthent.api.ServiceRegistry;

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
@Path("/v0/foodauthent")
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FileRestService{


    /**
     * TODO
     *
     * @param fileMetadata The actual metadata object.
     * @return the response
     */
    @POST
    @Path("/file")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createFileMetadata(FileMetadata fileMetadata
);

    /**
     * TODO
     *
     * @param fileId 
     * @return the response
     */
    @GET
    @Path("/file/{file-id}/data")
    @Produces({ "application/binary" })
    public Response getFileData(@PathParam("file-id") java.util.UUID fileId
);

    /**
     * TODO
     *
     * @param fileId 
     * @return the response
     */
    @GET
    @Path("/file/{file-id}")
    @Produces({ "application/json" })
    public Response getFileMetadata(@PathParam("file-id") java.util.UUID fileId
);

    /**
     * TODO
     *
     * @param fileId 
     * @param filedata The binary file data.
     * @return the response
     */
    @PUT
    @Path("/file/{file-id}/data")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    public Response saveFileData(@PathParam("file-id") java.util.UUID fileId
, 
            @org.glassfish.jersey.media.multipart.FormDataParam("filedata") java.io.InputStream filedata,
            @org.glassfish.jersey.media.multipart.FormDataParam("filedata") org.glassfish.jersey.media.multipart.FormDataContentDisposition filedataDetail
);
}

