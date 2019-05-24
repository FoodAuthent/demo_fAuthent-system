/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.FingerprintSetPageResult;

import org.foodauthent.api.FingerprintsetService;
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
public interface FingerprintsetRestService{


    /**
     * Create a new fingerprint set.
     *
     * @param fingerprintSet A fingerprint set containing fingerprint metadata.
     * @return the response
     */
    @POST
    @Path("/fingerprintset")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createFingerprintSet(FingerprintSet fingerprintSet
);

    /**
     * Muliple keywords can be provided with comma separated strings,e.g. use keyword1, keyword2, keyword3.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/fingerprintset")
    @Produces({ "application/json" })
    public Response findFingerprintSetByKeyword(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Get the fingerprintset by id.
     *
     * @param fingerprintsetId 
     * @return the response
     */
    @GET
    @Path("/fingerprintset/{fingerprintset-id}")
    @Produces({ "application/json" })
    public Response getFingerprintSetById(@PathParam("fingerprintset-id") java.util.UUID fingerprintsetId
);
}

