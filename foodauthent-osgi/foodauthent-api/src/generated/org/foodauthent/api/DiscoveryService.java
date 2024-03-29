/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.DiscoveryServiceSearchFilter;
import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.DiscoveryServiceTransactionPageResult;

import org.foodauthent.common.exception.FAExceptions;

/**
 * All Discovery Transaction related endpoints.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface DiscoveryService {

    /**
     * Creates/adds a new Transaction.
     *
     * @param requestBody list of DiscoveryServiceTransactions
     *
     * @return the result
     */
    java.util.List<java.util.UUID> createTransaction(java.util.List<DiscoveryServiceTransaction> requestBody);
        
    /**
     * Find Transaction by filters
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param discoveryServiceSearchFilter 
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ModelNotFoundResponse Response thrown when an model could not be found.
     * @throws FAException Unspecified exception.
     */
    DiscoveryServiceTransactionPageResult findTransactionByFilter(Integer pageNumber, Integer pageSize, DiscoveryServiceSearchFilter discoveryServiceSearchFilter) throws FAExceptions.UnauthorizedResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.FAException;
        
    /**
     * Muliple keywords can be provided with comma separated strings, e.g, keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    DiscoveryServiceTransactionPageResult findTransactionByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * Returns hashed epcClass from gtin and lot.
     *
     * @param gtin product gtin
     * @param lot product lot
     *
     * @return the result
     */
    String getSha256EpcClass(String gtin, String lot);
        
    /**
     * Get the Transaction an id.
     *
     * @param transactionId 
     *
     * @return the result
     */
    DiscoveryServiceTransaction getTransactionById(java.util.UUID transactionId);
        
}
