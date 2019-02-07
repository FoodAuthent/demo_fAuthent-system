/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.FingerprintSetPageResult;

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
@Component(service = FingerprintRestService.class, immediate = true)
public class FingerprintRestServiceImpl implements FingerprintRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private FingerprintService service;


    /**
     * Create a new fingerprint set.
     *
     * @param fingerprintSet A fingerprint set containing fingerprint metadata.
     * @return the response
     */
    public Response createFingerprintSet(FingerprintSet fingerprintSet) {
        
            Object res = service.createFingerprintSet(fingerprintSet);
            return Response.ok(res).build();
    }

    /**
     * Muliple keywords can be provided with comma separated strings,e.g. use keyword1, keyword2, keyword3.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findFingerprintSetByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findFingerprintSetByKeyword(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * Get the fingerprintset by id.
     *
     * @param fingerprintsetId 
     * @return the response
     */
    public Response getFingerprintSetById(java.util.UUID fingerprintsetId) {
        
            Object res = service.getFingerprintSetById(fingerprintsetId);
            return Response.ok(res).build();
    }
}

