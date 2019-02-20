/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.TransactionPageResult;

import org.foodauthent.common.exception.FAExceptions;

/**
 * All Transaction related endpoints.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface TransactionService {

    /**
     * Creates/adds a new Transaction.
     *
     * @param discoveryServiceTransaction TODO
     *
     * @return the result
     */
    java.util.UUID createTransaction(DiscoveryServiceTransaction discoveryServiceTransaction);
        
    /**
     * Muliple keywords can be provided with comma separated strings, e.g, keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    TransactionPageResult findTransactionByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * Get the Transaction an id.
     *
     * @param transactionId 
     *
     * @return the result
     */
    DiscoveryServiceTransaction getTransactionById(java.util.UUID transactionId);
        
}
