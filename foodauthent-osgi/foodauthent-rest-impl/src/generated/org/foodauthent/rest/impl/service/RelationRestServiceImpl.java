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


import org.foodauthent.api.RelationService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.RelationRestService;

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
@Component(service = RelationRestService.class, immediate = true)
public class RelationRestServiceImpl implements RelationRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private RelationService service;


    /**
     *
     * @return the response
     */
    public Response getEntities() {
        
            Object res = service.getEntities();
            return Response.ok(res).build();
    }

    /**
     *
     * @param entityName root entity name.
     * @param faId fa-id to match with in referenced entities.
     * @param referencedEntity root entity name.
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @return the response
     */
    public Response getForeignKeyEntities(String entityName, java.util.UUID faId, String referencedEntity, Integer pageNumber, Integer pageSize) {
        
            Object res = service.getForeignKeyEntities(entityName, faId, referencedEntity, pageNumber, pageSize);
            return Response.ok(res).build();
    }

    /**
     *
     * @param entityName root entity name.
     * @return the response
     */
    public Response getSupportedEntities(String entityName) {
        
            Object res = service.getSupportedEntities(entityName);
            return Response.ok(res).build();
    }
}

