/*
 * TODO	
 */
package org.foodauthent.api;


import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface EntityService {

    /**
     * Delete an fa-entity with specified by id (files or models).
     *
     * @param faId 
     *
     * 
     */
    void removeEntity(java.util.UUID faId);
        
}
