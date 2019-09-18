/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import org.foodauthent.model.DiscoveryServiceSearchFilter;
import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.DiscoveryServiceTransactionPageResult;

import org.foodauthent.api.TransactionService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.TransactionRestService;

import org.foodauthent.common.exception.FAExceptions;

/**
 * FoodAuthent Swagger API
 *
 * <p>This is the FoodAuthent API Description [www.foodauthent.net]
 *
 * <p> All Transaction related endpoints.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
@Component(service = TransactionRestService.class, immediate = true)
public class TransactionRestServiceImpl implements TransactionRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private TransactionService service;


    /**
     * Creates/adds a new Transaction.
     *
     * @param discoveryServiceTransaction TODO
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
        
            Object res = service.findTransactionByFilter(pageNumber, pageSize, discoveryServiceSearchFilter);
            return Response.ok(res).build();
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

