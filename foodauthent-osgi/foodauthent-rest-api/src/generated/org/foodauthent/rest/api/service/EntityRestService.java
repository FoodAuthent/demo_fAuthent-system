/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import org.foodauthent.auth.security.SecurityScheme;


import org.foodauthent.api.EntityService;
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
public interface EntityRestService{


    /**
     * Delete an fa-entity with specified by id (files or models).
     *
     * @param faId 
     * @return the response
     */
    @DELETE
    @Path("/entity/{fa-id}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    public Response removeEntity(@PathParam("fa-id") java.util.UUID faId
);
}

