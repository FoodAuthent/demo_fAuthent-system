/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import org.foodauthent.auth.security.SecurityScheme;

import org.foodauthent.model.Model;
import org.foodauthent.model.ModelPageResult;
import org.foodauthent.model.ObjectEvent;
import org.foodauthent.model.PublishMetadata;

import org.foodauthent.api.ModelService;
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
public interface ModelRestService{


    /**
     * Creates/adds a new model.
     *
     * @param model TODO
     * @return the response
     */
    @POST
    @Path("/model")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createModel(Model model
);

    /**
     * Muliple keywords can be provided with comma separated strings, e.g. keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/model")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response findModelByKeyword(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * TODO
     *
     * @param modelId 
     * @return the response
     */
    @GET
    @Path("/model/{model-id}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response getModelById(@PathParam("model-id") java.util.UUID modelId
);

    /**
     * TODO
     *
     * @param modelId 
     * @param publishMetadata TODO
     * @return the response
     */
    @POST
    @Path("/model/{model-id}/publish")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response publishModelById(@PathParam("model-id") java.util.UUID modelId
, PublishMetadata publishMetadata
);

    /**
     * TODO
     *
     * @param model TODO
     * @return the response
     */
    @PUT
    @Path("/model")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Consumes({ "application/json" })
    public Response updatedModel(Model model
);
}

