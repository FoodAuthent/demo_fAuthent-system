/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import org.foodauthent.model.ObjectEvent;
import org.foodauthent.model.ObjectEventPageResult;

import org.foodauthent.api.ObjectEventService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.ObjectEventRestService;

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
@Component(service = ObjectEventRestService.class, immediate = true)
public class ObjectEventRestServiceImpl implements ObjectEventRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private ObjectEventService service;


    /**
     * Creates/adds a new ObjectEvent.
     *
     * @param objectEvent TODO
     * @return the response
     */
    public Response createObjectEvent(ObjectEvent objectEvent) {
        
            Object res = service.createObjectEvent(objectEvent);
            return Response.ok(res).build();
    }

    /**
     * Muliple keywords(epcClass) can be provided with comma separated strings, e.g, keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findObjectEventByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findObjectEventByKeyword(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }
}

