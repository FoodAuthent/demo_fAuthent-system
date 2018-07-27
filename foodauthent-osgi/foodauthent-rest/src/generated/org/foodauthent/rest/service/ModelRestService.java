/*
 * TODO	
 */
package org.foodauthent.rest.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.Model;

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
public class ModelRestService{

    private final ModelService service = ServiceRegistry.get(ModelService.class);


    /**
     * Creates/adds a new model.
     *
     * @param model TODO
     * @return the response
     */
    @POST
    @Path("/model")
    @Consumes({ "application/json" })
    public Response createModel(Model model
) {
        
            Object res = service.createModel(model);
            return Response.ok(res).build();
    }

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
) {
        
            Object res = service.getModelById(modelId);
            return Response.ok(res).build();
    }
}

