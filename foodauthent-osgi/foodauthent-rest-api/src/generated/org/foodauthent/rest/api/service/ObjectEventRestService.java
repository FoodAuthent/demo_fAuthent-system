/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.ObjectEvent;
import org.foodauthent.model.ObjectEventPageResult;

import org.foodauthent.api.ObjectEventService;
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
public interface ObjectEventRestService{


    /**
     * Creates/adds a new ObjectEvent.
     *
     * @param objectEvent TODO
     * @return the response
     */
    @POST
    @Path("/epcis/objectEvent/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createObjectEvent(ObjectEvent objectEvent
);

    /**
     * Muliple keywords(epcClass) can be provided with comma separated strings, e.g, keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/epcis/objectEvent/")
    @Produces({ "application/json" })
    public Response findObjectEventByKeyword(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Get the ObjectEvent an id.
     *
     * @param objecteventId 
     * @return the response
     */
    @GET
    @Path("/epcis/objectEvent/{objectevent-id}")
    @Produces({ "application/json" })
    public Response getObjectEventById(@PathParam("objectevent-id") java.util.UUID objecteventId
);
}

