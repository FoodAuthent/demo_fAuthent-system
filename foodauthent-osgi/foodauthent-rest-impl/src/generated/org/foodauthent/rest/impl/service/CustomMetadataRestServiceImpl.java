/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


import org.foodauthent.api.CustomMetadataService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.CustomMetadataRestService;

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
public class CustomMetadataRestServiceImpl implements CustomMetadataRestService {

    private final CustomMetadataService service = ServiceRegistry.get(CustomMetadataService.class);


    /**
     * TODO
     *
     * @param modelId 
     * @param schemaId 
     * @param faId 
     * @return the response
     */
    public Response getCustomMetadata(String modelId, String schemaId, java.util.UUID faId) {
        
            Object res = service.getCustomMetadata(modelId, schemaId, faId);
            return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param modelId 
     * @param schemaId 
     * @return the response
     */
    public Response getCustomMetadataSchema(String modelId, String schemaId) {
        
            Object res = service.getCustomMetadataSchema(modelId, schemaId);
            return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param modelId 
     * @return the response
     */
    public Response getCustomMetadataSchemas(String modelId) {
        
            Object res = service.getCustomMetadataSchemas(modelId);
            return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param modelId 
     * @param schemaId 
     * @param faId 
     * @param body 
     * @return the response
     */
    public Response saveCustomMetadata(String modelId, String schemaId, java.util.UUID faId, String body) {
        
            service.saveCustomMetadata(modelId, schemaId, faId, body);
            
                return Response.ok().build();
    }
}

