/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import org.foodauthent.model.UserAuthenticationRequest;

import org.foodauthent.api.AuthenticationService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.AuthenticationRestService;

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
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
@Component(service = AuthenticationRestService.class, immediate = true)
public class AuthenticationRestServiceImpl implements AuthenticationRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private AuthenticationService service;


    /**
     * TODO
     *
     * @param userAuthenticationRequest TODO
     * @return the response
     */
    public Response authenticateUserJSONWebToken(UserAuthenticationRequest userAuthenticationRequest) {
        try { 
            Object res = service.authenticateUserJSONWebToken(userAuthenticationRequest);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * TODO
     *
     * @param body User&#39;s JSON Web Token to refresh
     * @return the response
     */
    public Response refreshJSONWebToken(String body) {
        try { 
            Object res = service.refreshJSONWebToken(body);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * TODO
     *
     * @param body JWT token to be verfied
     * @return the response
     */
    public Response verifyJSONWebToken(String body) {
        try { 
            service.verifyJSONWebToken(body);
            
                return Response.ok().build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }
}

