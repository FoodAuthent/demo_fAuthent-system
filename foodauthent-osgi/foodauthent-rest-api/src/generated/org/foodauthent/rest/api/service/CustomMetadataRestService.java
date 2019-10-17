/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import org.foodauthent.auth.security.SecurityScheme;


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
     * @param modelType 
     * @param schemaId 
     * @param faId 
     * @return the response
     */
    @GET
    @Path("/custommetadata/{model-type}/{schema-id}/{fa-id}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response getCustomMetadata(@PathParam("model-type") String modelType
, @PathParam("schema-id") String schemaId
, @PathParam("fa-id") java.util.UUID faId
);

    /**
     * TODO
     *
     * @param modelType 
     * @param schemaId 
     * @return the response
     */
    @GET
    @Path("/custommetadata/{model-type}/{schema-id}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/schema+json" })
    public Response getCustomMetadataSchema(@PathParam("model-type") String modelType
, @PathParam("schema-id") String schemaId
);

    /**
     * TODO
     *
     * @param modelType 
     * @return the response
     */
    @GET
    @Path("/custommetadata/{model-type}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response getCustomMetadataSchemas(@PathParam("model-type") String modelType
);

    /**
     * TODO
     *
     * @param modelType 
     * @param schemaId 
     * @param faId 
     * @param body 
     * @return the response
     */
    @POST
    @Path("/custommetadata/{model-type}/{schema-id}/{fa-id}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Consumes({ "application/json" })
    public Response saveCustomMetadata(@PathParam("model-type") String modelType
, @PathParam("schema-id") String schemaId
, @PathParam("fa-id") java.util.UUID faId
, String body
);
}

