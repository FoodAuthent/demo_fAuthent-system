/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.SOP;

import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface SopService {

    /**
     * TODO
     *
     * @param sop TODO
     *
     * @return the result
     */
    java.util.UUID createNewSOP(SOP sop) 
;
        
    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    java.util.List<java.util.UUID> findSOPByKeyword(java.util.List<String> keywords) 
;
        
    /**
     * TODO
     *
     * @param sopId 
     *
     * @return the result
     */
    SOP getSOPById(java.util.UUID sopId) 
;
        
}
