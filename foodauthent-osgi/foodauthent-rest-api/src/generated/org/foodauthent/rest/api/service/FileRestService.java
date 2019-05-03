/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.FaObjectSet;
import java.io.File;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.ImportResult;

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
     * Creates a new file by posting the file metadata first.
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
     * Export FoodAuthent components
     *
     * @param fileType 
     * @param faObjectSet Specifies a set of fa-objects to be exported.
     * @return the response
     */
    @POST
    @Path("/file/{file-id}/export")
    @Consumes({ "application/json" })
    @Produces({ "application/binary" })
    public Response exportFile(@QueryParam("file-type")String fileType
, FaObjectSet faObjectSet
);

    /**
     * Let one download the actual file data.
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
     * Returns the file metadata.
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
     * Import FoodAuthent components from an existing ZIP file and return the ids of the components.
     *
     * @param fileId 
     * @return the response
     */
    @GET
    @Path("/file/{file-id}/import")
    @Produces({ "application/json" })
    public Response importFile(@PathParam("file-id") java.util.UUID fileId
);

    /**
     * Removes the file and it&#39;s metadata for the given id
     *
     * @param fileId 
     * @return the response
     */
    @DELETE
    @Path("/file/{file-id}")
    public Response removeFileMetadataAndData(@PathParam("file-id") java.util.UUID fileId
);

    /**
     * Uploads (and replaces) the actual file-data for the given file id
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

