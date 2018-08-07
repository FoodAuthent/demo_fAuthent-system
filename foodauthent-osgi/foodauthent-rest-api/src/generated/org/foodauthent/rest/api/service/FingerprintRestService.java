/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.FingerprintSet;

import org.foodauthent.api.FingerprintService;
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
public interface FingerprintRestService{


    /**
     * TODO
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
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/fingerprintset")
    @Produces({ "application/json" })
    public Response findFingerprintSetByKeyword(@QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * TODO
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

