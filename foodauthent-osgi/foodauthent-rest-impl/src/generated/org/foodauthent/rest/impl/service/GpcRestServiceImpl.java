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

import org.foodauthent.model.GPCBrickData;

import org.foodauthent.api.GpcService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.GpcRestService;

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
@Component(service = GpcRestService.class, immediate = true)
public class GpcRestServiceImpl implements GpcRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private GpcService service;


    /**
     * find gpc bricks by filter
     *
     * @param s 
     * @param lang 
     * @return the response
     */
    public Response findGpcBricks(String s, String lang) {
        try { 
            Object res = service.findGpcBricks(s, lang);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ModelNotFoundResponse e) {
           return Response.status(404).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }
}

