/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.SOP;
import org.foodauthent.model.SOPPageResult;

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
public interface SopRestService{


    /**
     * TODO
     *
     * @param sop TODO
     * @return the response
     */
    @POST
    @Path("/sop")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createNewSOP(SOP sop
);

    /**
     * Muliple tags can be provided with comma separated strings. Use keyword1, keyword2, keyword3 for testing. If no keyword is specified, all entries will be considered.
     *
     * @param pageNumber 
     * @param pageSize 
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/sop")
    @Produces({ "application/json" })
    public Response findSOPByKeyword(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

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
);
}

