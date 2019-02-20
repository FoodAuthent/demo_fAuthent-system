/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.ObjectEvent;
import org.foodauthent.model.ObjectEventPageResult;

import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ObjectEventService {

    /**
     * Creates/adds a new ObjectEvent.
     *
     * @param objectEvent TODO
     *
     * @return the result
     */
    java.util.UUID createObjectEvent(ObjectEvent objectEvent);
        
    /**
     * Muliple keywords(epcClass) can be provided with comma separated strings, e.g, keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    ObjectEventPageResult findObjectEventByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * Get the ObjectEvent an id.
     *
     * @param objecteventId 
     *
     * @return the result
     */
    ObjectEvent getObjectEventById(java.util.UUID objecteventId);
        
}
