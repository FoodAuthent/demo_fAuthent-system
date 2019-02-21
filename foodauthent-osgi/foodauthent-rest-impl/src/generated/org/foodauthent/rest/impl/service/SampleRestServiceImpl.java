/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import org.foodauthent.model.Sample;
import org.foodauthent.model.SamplePageResult;

import org.foodauthent.api.SampleService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.SampleRestService;

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
@Component(service = SampleRestService.class, immediate = true)
public class SampleRestServiceImpl implements SampleRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private SampleService service;


    /**
     * Creates/adds a new Sample.
     *
     * @param sample TODO
     * @return the response
     */
    public Response createSample(Sample sample) {
        
            Object res = service.createSample(sample);
            return Response.ok(res).build();
    }

    /**
     * Muliple keywords can be provided with comma separated strings, e.g, keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findSampleByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findSampleByKeyword(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * Get the Sample an id.
     *
     * @param sampleId 
     * @return the response
     */
    public Response getSampleById(java.util.UUID sampleId) {
        
            Object res = service.getSampleById(sampleId);
            return Response.ok(res).build();
    }
}

