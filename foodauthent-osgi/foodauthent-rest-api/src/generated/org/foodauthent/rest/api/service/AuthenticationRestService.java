/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.UserAuthenticationRequest;

import org.foodauthent.api.AuthenticationService;
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
public interface AuthenticationRestService{


    /**
     * TODO
     *
     * @param userAuthenticationRequest TODO
     * @return the response
     */
    @POST
    @Path("/authenticate/jwt")
    @Consumes({ "application/json" })
    @Produces({ "text/plain" })
    public Response authenticateUserJSONWebToken(UserAuthenticationRequest userAuthenticationRequest
);

    /**
     * TODO
     *
     * @param body User&#39;s JSON Web Token to refresh
     * @return the response
     */
    @POST
    @Path("/authenticate/jwt/refresh")
    @Consumes({ "text/plain" })
    @Produces({ "text/plain" })
    public Response refreshJSONWebToken(String body
);

    /**
     * TODO
     *
     * @param body JWT token to be verfied
     * @return the response
     */
    @POST
    @Path("/authenticate/jwt/verify")
    @Consumes({ "text/plain" })
    @Produces({ "text/plain" })
    public Response verifyJSONWebToken(String body
);
}

