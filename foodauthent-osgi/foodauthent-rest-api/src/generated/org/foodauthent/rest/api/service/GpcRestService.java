/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import org.foodauthent.auth.security.SecurityScheme;

import org.foodauthent.model.GPCBrickData;

import org.foodauthent.api.GpcService;
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
public interface GpcRestService{


    /**
     * find gpc bricks by filter
     *
     * @param s 
     * @param lang 
     * @return the response
     */
    @GET
    @Path("/gpc")
    @Produces({ "application/json", "text/plain" })
    public Response findGpcBricks(@QueryParam("s")String s
, @QueryParam("lang")String lang
);
}

