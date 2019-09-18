/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.DiscoveryServiceSearchFilter;
import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.DiscoveryServiceTransactionPageResult;

import org.foodauthent.api.TransactionService;
import org.foodauthent.api.ServiceRegistry;

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
@Path("/v0/foodauthent")
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface TransactionRestService{


    /**
     * Creates/adds a new Transaction.
     *
     * @param discoveryServiceTransaction list of DiscoveryServiceTransactions
     * @return the response
     */
    @POST
    @Path("/discovery/transaction")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createTransaction(java.util.List<DiscoveryServiceTransaction> discoveryServiceTransaction
);

    /**
     * Find Transaction by filters
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param discoveryServiceSearchFilter 
     * @return the response
     */
    @POST
    @Path("/discovery/transaction/findTransactionByFilter")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response findTransactionByFilter(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, DiscoveryServiceSearchFilter discoveryServiceSearchFilter
);

    /**
     * Muliple keywords can be provided with comma separated strings, e.g, keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/discovery/transaction")
    @Produces({ "application/json" })
    public Response findTransactionByKeyword(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Get the Transaction an id.
     *
     * @param transactionId 
     * @return the response
     */
    @GET
    @Path("/discovery/transaction/{transaction-id}")
    @Produces({ "application/json" })
    public Response getTransactionById(@PathParam("transaction-id") java.util.UUID transactionId
);
}

