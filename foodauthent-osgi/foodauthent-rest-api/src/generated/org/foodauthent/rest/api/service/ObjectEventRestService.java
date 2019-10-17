/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import org.foodauthent.auth.security.SecurityScheme;

import org.foodauthent.model.DiscoveryServiceTransaction;
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
     * Convert the ObjectEvent to Discovery Service Transaction.
     *
     * @param objecteventId 
     * @return the response
     */
    @GET
    @Path("/epcis/objectEvent/{objectevent-id}/discovery")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response convertObjectEventToTransaction(@PathParam("objectevent-id") java.util.UUID objecteventId
);

    /**
     * Creates/adds a new ObjectEvent.
     *
     * @param objectEvent TODO
     * @return the response
     */
    @POST
    @Path("/epcis/objectEvent/")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createObjectEvent(ObjectEvent objectEvent
);

    /**
     * Muliple keywords(epcClass) can be provided with comma separated strings, e.g, keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/epcis/objectEvent/")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
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
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response getObjectEventById(@PathParam("objectevent-id") java.util.UUID objecteventId
);
}

