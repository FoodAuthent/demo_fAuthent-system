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

import org.foodauthent.model.SystemInfo;

import org.foodauthent.api.InfoService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.InfoRestService;

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
@Component(service = InfoRestService.class, immediate = true)
public class InfoRestServiceImpl implements InfoRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private InfoService service;


    /**
     * statistics and status
     *
     * @return the response
     */
    public Response getInfo() {
        
            Object res = service.getInfo();
            return Response.ok(res).build();
    }
}

