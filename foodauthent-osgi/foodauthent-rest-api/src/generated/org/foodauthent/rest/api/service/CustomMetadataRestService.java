/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


import org.foodauthent.api.CustomMetadataService;
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
public interface CustomMetadataRestService{


    /**
     * TODO
     *
     * @param modelId 
     * @param schemaId 
     * @param faId 
     * @return the response
     */
    @GET
    @Path("/custommetadata/{model-id}/{schema-id}/{fa-id}")
    @Produces({ "application/json" })
    public Response getCustomMetadata(@PathParam("model-id") String modelId
, @PathParam("schema-id") String schemaId
, @PathParam("fa-id") java.util.UUID faId
);

    /**
     * TODO
     *
     * @param modelId 
     * @param schemaId 
     * @return the response
     */
    @GET
    @Path("/custommetadata/{model-id}/{schema-id}")
    @Produces({ "application/schema+json" })
    public Response getCustomMetadataSchema(@PathParam("model-id") String modelId
, @PathParam("schema-id") String schemaId
);

    /**
     * TODO
     *
     * @param modelId 
     * @return the response
     */
    @GET
    @Path("/custommetadata/{model-id}")
    @Produces({ "application/json" })
    public Response getCustomMetadataSchemas(@PathParam("model-id") String modelId
);

    /**
     * TODO
     *
     * @param modelId 
     * @param schemaId 
     * @param faId 
     * @param body 
     * @return the response
     */
    @POST
    @Path("/custommetadata/{model-id}/{schema-id}/{fa-id}")
    @Consumes({ "application/json" })
    public Response saveCustomMetadata(@PathParam("model-id") String modelId
, @PathParam("schema-id") String schemaId
, @PathParam("fa-id") java.util.UUID faId
, String body
);
}

