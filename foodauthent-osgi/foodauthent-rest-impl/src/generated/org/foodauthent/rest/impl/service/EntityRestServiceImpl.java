/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.core.Response;

import org.foodauthent.api.EntityService;
import org.foodauthent.rest.api.service.EntityRestService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

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
@Component(service = EntityRestService.class, immediate = true)
public class EntityRestServiceImpl implements EntityRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private EntityService service;


    /**
     * Delete an fa-entity with specified by id (files or models).
     *
     * @param faId 
     * @return the response
     */
    public Response removeEntity(java.util.UUID faId) {
        
            service.removeEntity(faId);
            
                return Response.ok().build();
    }
}

