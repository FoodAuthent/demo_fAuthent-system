/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.Model;
import org.foodauthent.model.ModelPageResult;

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
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createModel(Model model
);

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber 
     * @param pageSize 
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/model")
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
    @Produces({ "application/json" })
    public Response getModelById(@PathParam("model-id") java.util.UUID modelId
);
}

