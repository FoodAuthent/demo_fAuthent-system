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
public interface FingerprintService {

    /**
     * TODO
     *
     * @param fingerprintSet A fingerprint set containing fingerprint metadata.
     *
     * @return the result
     */
    java.util.UUID createFingerprintSet(FingerprintSet fingerprintSet);
        
    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    FingerprintSetPageResult findFingerprintSetByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * TODO
     *
     * @param fingerprintsetId 
     *
     * @return the result
     */
    FingerprintSet getFingerprintSetById(java.util.UUID fingerprintsetId);
        
}
