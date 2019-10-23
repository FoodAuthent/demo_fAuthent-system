/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import org.foodauthent.model.DiscoveryServiceSearchFilter;
import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.DiscoveryServiceTransactionPageResult;

import org.foodauthent.api.DiscoveryService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.DiscoveryRestService;

import org.foodauthent.common.exception.FAExceptions;

/**
 * FoodAuthent Swagger API
 *
 * <p>This is the FoodAuthent API Description [www.foodauthent.net]
 *
 * <p> All Discovery Transaction related endpoints.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
@Component(service = DiscoveryRestService.class, immediate = true)
public class DiscoveryRestServiceImpl implements DiscoveryRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private DiscoveryService service;


    /**
     * Creates/adds a new Transaction.
     *
     * @param discoveryServiceTransaction list of DiscoveryServiceTransactions
     * @return the response
     */
    public Response createTransaction(java.util.List<DiscoveryServiceTransaction> discoveryServiceTransaction) {
        
            Object res = service.createTransaction(discoveryServiceTransaction);
            return Response.ok(res).build();
    }

    /**
     * Find Transaction by filters
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param discoveryServiceSearchFilter 
     * @return the response
     */
    public Response findTransactionByFilter(Integer pageNumber, Integer pageSize, DiscoveryServiceSearchFilter discoveryServiceSearchFilter) {
        try { 
            Object res = service.findTransactionByFilter(pageNumber, pageSize, discoveryServiceSearchFilter);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ModelNotFoundResponse e) {
           return Response.status(404).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * Muliple keywords can be provided with comma separated strings, e.g, keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findTransactionByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findTransactionByKeyword(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * Returns hashed epcClass from gtin and lot.
     *
     * @param gtin product gtin
     * @param lot product lot
     * @return the response
     */
    public Response getSha256EpcClass(String gtin, String lot) {
        
            Object res = service.getSha256EpcClass(gtin, lot);
            return Response.ok(res).build();
    }

    /**
     * Get the Transaction an id.
     *
     * @param transactionId 
     * @return the response
     */
    public Response getTransactionById(java.util.UUID transactionId) {
        
            Object res = service.getTransactionById(transactionId);
            return Response.ok(res).build();
    }
}

