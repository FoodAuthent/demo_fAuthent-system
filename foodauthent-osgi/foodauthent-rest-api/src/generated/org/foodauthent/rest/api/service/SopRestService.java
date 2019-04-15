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
     * Creates a new SOP.
     *
     * @param SOP TODO
     * @return the response
     */
    @POST
    @Path("/sop")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createNewSOP(SOP SOP
);

    /**
     * Muliple tags can be provided with comma separated strings. Use keyword1, keyword2, keyword3 for testing. If no keyword is specified, all entries will be considered.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
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
     * Get the sop an id.
     *
     * @param sopId 
     * @return the response
     */
    @GET
    @Path("/sop/{sop-id}")
    @Produces({ "application/json" })
    public Response getSOPById(@PathParam("sop-id") java.util.UUID sopId
);

    /**
     * Delete a sop specified by id.
     *
     * @param sopId 
     * @return the response
     */
    @DELETE
    @Path("/sop/{sop-id}")
    public Response removeSOPById(@PathParam("sop-id") java.util.UUID sopId
);
}

