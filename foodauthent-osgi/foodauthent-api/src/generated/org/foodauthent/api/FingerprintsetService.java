/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.FingerprintSetPageResult;

import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FingerprintsetService {

    /**
     * Create a new fingerprint set.
     *
     * @param fingerprintSet A fingerprint set containing fingerprint metadata.
     *
     * @return the result
     */
    java.util.UUID createFingerprintSet(FingerprintSet fingerprintSet);
        
    /**
     * Muliple keywords can be provided with comma separated strings,e.g. use keyword1, keyword2, keyword3.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    FingerprintSetPageResult findFingerprintSetByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * Get the fingerprintset by id.
     *
     * @param fingerprintsetId 
     *
     * @return the result
     */
    FingerprintSet getFingerprintSetById(java.util.UUID fingerprintsetId);
        
}
