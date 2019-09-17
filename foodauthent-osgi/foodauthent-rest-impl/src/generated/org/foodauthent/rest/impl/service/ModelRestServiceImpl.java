/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import org.foodauthent.model.Model;
import org.foodauthent.model.ModelPageResult;
import org.foodauthent.model.ObjectEvent;
import org.foodauthent.model.PublishMetadata;

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
@Component(service = ModelRestService.class, immediate = true)
public class ModelRestServiceImpl implements ModelRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private ModelService service;


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
     * Muliple keywords can be provided with comma separated strings, e.g. keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findModelByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findModelByKeyword(pageNumber, pageSize, keywords);
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

    /**
     * TODO
     *
     * @param modelId 
     * @param publishMetadata TODO
     * @return the response
     */
    public Response publishModelById(java.util.UUID modelId, PublishMetadata publishMetadata) {
        
            Object res = service.publishModelById(modelId, publishMetadata);
            return Response.ok(res).build();
    }
}

