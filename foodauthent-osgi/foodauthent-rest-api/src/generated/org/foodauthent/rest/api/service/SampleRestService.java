/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.Sample;
import org.foodauthent.model.SamplePageResult;

import org.foodauthent.api.SampleService;
import org.foodauthent.api.ServiceRegistry;

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
@Path("/v0/foodauthent")
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface SampleRestService{


    /**
     * Creates/adds a new Sample.
     *
     * @param sample TODO
     * @return the response
     */
    @POST
    @Path("/sample")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createSample(Sample sample
);

    /**
     * Muliple keywords can be provided with comma separated strings, e.g, keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/sample")
    @Produces({ "application/json" })
    public Response findSampleByKeyword(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Get the Sample an id.
     *
     * @param sampleId 
     * @return the response
     */
    @GET
    @Path("/sample/{sample-id}")
    @Produces({ "application/json" })
    public Response getSampleById(@PathParam("sample-id") java.util.UUID sampleId
);
}

