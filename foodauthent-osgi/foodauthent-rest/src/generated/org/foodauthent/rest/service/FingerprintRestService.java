/*
 * TODO	
 */
package org.foodauthent.rest.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.FingerprintSet;

import org.foodauthent.api.FingerprintService;
import org.foodauthent.api.ServiceRegistry;

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
public class FingerprintRestService{

	private final FingerprintService service = ServiceRegistry.get(FingerprintService.class);


    /**
     * TODO
     *
     * @param fingerprintSet A fingerprint set containing fingerprint metadata.
     * @return the response
     */
    @POST
    @Path("/fingerprints")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createFingerprintSet(FingerprintSet fingerprintSet) {
	    Object res = service.createFingerprintSet(fingerprintSet);    
	   	return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/fingerprints")
    @Produces({ "application/json" })
    public Response findFingerprintSetByKeyword(@QueryParam("keywords")java.util.List<String> keywords) {
	    Object res = service.findFingerprintSetByKeyword(keywords);    
	   	return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param fingerprintsetId 
     * @return the response
     */
    @GET
    @Path("/fingerprintset/{fingerprintset-id}")
    @Produces({ "application/json" })
    public Response getFingerprintSetById(@PathParam("fingerprintset-id") java.util.UUID fingerprintsetId) {
	    Object res = service.getFingerprintSetById(fingerprintsetId);    
	   	return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param data 
     * @param fingerprintsetId The fingerprintset the data is associated with.
     * @return the response
     */
    @POST
    @Path("/fingerprintdata")
    @Consumes({ "application/json" })
    public Response uploadFingerprintDataset(byte[] data, @QueryParam("fingerprintset-id")java.util.UUID fingerprintsetId) {
	    service.uploadFingerprintDataset(data, fingerprintsetId);    
    	return Response.ok().build();
    }
}

