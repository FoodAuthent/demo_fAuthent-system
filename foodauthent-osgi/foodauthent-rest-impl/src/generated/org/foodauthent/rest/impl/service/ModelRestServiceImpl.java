/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.Model;
import org.foodauthent.model.ModelPageResult;
import org.foodauthent.model.WorkflowPageResult;

import org.foodauthent.api.ModelService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.ModelRestService;

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
public class ModelRestServiceImpl implements ModelRestService {

    private final ModelService service = ServiceRegistry.get(ModelService.class);


    /**
     * Creates/adds a new model.
     *
     * @param model TODO
     * @return the response
     */
    public Response createModel(Model model) {
        
            Object res = service.createModel(model);
            return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber 
     * @param pageSize 
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findModelByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findModelByKeyword(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber 
     * @param pageSize 
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findWorkflowByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findWorkflowByKeyword(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param modelId 
     * @return the response
     */
    public Response getModelById(java.util.UUID modelId) {
        
            Object res = service.getModelById(modelId);
            return Response.ok(res).build();
    }
}

