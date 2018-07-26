/*
 * TODO	
 */
package org.foodauthent.rest.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.SOP;

import org.foodauthent.api.SopService;
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
public class SopRestService{

	private final SopService service = ServiceRegistry.get(SopService.class);


    /**
     * TODO
     *
     * @param sop TODO
     * @return the response
     */
    @POST
    @Path("/sop")
    @Produces({ "application/json" })
    public Response createNewSOP(SOP sop
) {
			Object res = service.createNewSOP(sop);    
			return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/sop")
    @Produces({ "application/json" })
    public Response findSOPByKeyword(@QueryParam("keywords")java.util.List<String> keywords
) {
			Object res = service.findSOPByKeyword(keywords);    
			return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param sopId 
     * @return the response
     */
    @GET
    @Path("/sop/{sop-id}")
    @Produces({ "application/json" })
    public Response getSOPById(@PathParam("sop-id") java.util.UUID sopId
) {
			Object res = service.getSOPById(sopId);    
			return Response.ok(res).build();
    }
}

