/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.SOP;

import org.foodauthent.api.SopService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.SopRestService;

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
public class SopRestServiceImpl implements SopRestService {

    private final SopService service = ServiceRegistry.get(SopService.class);


    /**
     * TODO
     *
     * @param sop TODO
     * @return the response
     */
    public Response createNewSOP(SOP sop) {
        
            Object res = service.createNewSOP(sop);
            return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findSOPByKeyword(java.util.List<String> keywords) {
        
            Object res = service.findSOPByKeyword(keywords);
            return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param sopId 
     * @return the response
     */
    public Response getSOPById(java.util.UUID sopId) {
        
            Object res = service.getSOPById(sopId);
            return Response.ok(res).build();
    }
}

