/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.FingerprintSet;

import org.foodauthent.api.FingerprintService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.FingerprintRestService;

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
public class FingerprintRestServiceImpl implements FingerprintRestService {

    private final FingerprintService service = ServiceRegistry.get(FingerprintService.class);


    /**
     * TODO
     *
     * @param fingerprintSet A fingerprint set containing fingerprint metadata.
     * @return the response
     */
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
    public Response findFingerprintSetByKeyword(java.util.List<String> keywords) {
        
            Object res = service.findFingerprintSetByKeyword(keywords);
            return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param fingerprintsetId 
     * @return the response
     */
    public Response getFingerprintSetById(java.util.UUID fingerprintsetId) {
        
            Object res = service.getFingerprintSetById(fingerprintsetId);
            return Response.ok(res).build();
    }
}

