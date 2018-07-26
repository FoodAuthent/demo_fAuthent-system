/*
 * TODO	
 */
package org.foodauthent.rest.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.MetadataEntries;

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
public class FingerprintRestService{

	private final FingerprintService service = ServiceRegistry.get(FingerprintService.class);


    /**
     * TODO
     *
     * @param fingerprintId The fingerprint the data is associated with.
     * @param data The raw data.
     * @return the response
     */
    @POST
    @Path("/fingerprint/addrawdata/{fingerprint-id}")
    @Consumes({ "application/json" })
    public Response addFingerprintRawData(@PathParam("fingerprint-id") java.util.UUID fingerprintId
, byte[] data
) {
			service.addFingerprintRawData(fingerprintId, data);    
			
    			return Response.ok().build();
    }

    /**
     * TODO
     *
     * @param fingerprintId The fingerprint the data is associated with.
     * @param metadata Metadata to add.
     * @return the response
     */
    @POST
    @Path("/fingerprint/addmetadata/{fingerprint-id}")
    @Consumes({ "application/json" })
    public Response addMetaData(@PathParam("fingerprint-id") java.util.UUID fingerprintId
, MetadataEntries metadata
) {
			service.addMetaData(fingerprintId, metadata);    
			
    			return Response.ok().build();
    }

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
    public Response createFingerprintSet(FingerprintSet fingerprintSet
) {
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
    public Response findFingerprintSetByKeyword(@QueryParam("keywords")java.util.List<String> keywords
) {
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
    public Response getFingerprintSetById(@PathParam("fingerprintset-id") java.util.UUID fingerprintsetId
) {
			Object res = service.getFingerprintSetById(fingerprintsetId);    
			return Response.ok(res).build();
    }
}

