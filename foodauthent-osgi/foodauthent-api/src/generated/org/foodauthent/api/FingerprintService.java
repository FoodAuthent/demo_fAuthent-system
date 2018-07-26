/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.MetadataEntries;

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
     * @param fingerprintId The fingerprint the data is associated with.
     * @param data The raw data.
     *
     * 
     */
    void addFingerprintRawData(java.util.UUID fingerprintId, byte[] data) 
;
        
    /**
     * TODO
     *
     * @param fingerprintId The fingerprint the data is associated with.
     * @param metadata Metadata to add.
     *
     * 
     */
    void addMetaData(java.util.UUID fingerprintId, MetadataEntries metadata) 
;
        
    /**
     * TODO
     *
     * @param fingerprintSet A fingerprint set containing fingerprint metadata.
     *
     * @return the result
     */
    java.util.UUID createFingerprintSet(FingerprintSet fingerprintSet) 
;
        
    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    java.util.List<java.util.UUID> findFingerprintSetByKeyword(java.util.List<String> keywords) 
;
        
    /**
     * TODO
     *
     * @param fingerprintsetId 
     *
     * @return the result
     */
    FingerprintSet getFingerprintSetById(java.util.UUID fingerprintsetId) 
;
        
}
