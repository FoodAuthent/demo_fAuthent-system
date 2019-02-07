/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import org.foodauthent.model.SOP;
import org.foodauthent.model.SOPPageResult;

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
@Component(service = SopRestService.class, immediate = true)
public class SopRestServiceImpl implements SopRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private SopService service;


    /**
     * Creates a new SOP.
     *
     * @param SOP TODO
     * @return the response
     */
    public Response createNewSOP(SOP SOP) {
        
            Object res = service.createNewSOP(SOP);
            return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use keyword1, keyword2, keyword3 for testing. If no keyword is specified, all entries will be considered.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findSOPByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findSOPByKeyword(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * Get the sop an id.
     *
     * @param sopId 
     * @return the response
     */
    public Response getSOPById(java.util.UUID sopId) {
        
            Object res = service.getSOPById(sopId);
            return Response.ok(res).build();
    }

    /**
     * Delete a sop specified by id.
     *
     * @param sopId 
     * @return the response
     */
    public Response removeSOPById(java.util.UUID sopId) {
        
            service.removeSOPById(sopId);
            
                return Response.ok().build();
    }
}

