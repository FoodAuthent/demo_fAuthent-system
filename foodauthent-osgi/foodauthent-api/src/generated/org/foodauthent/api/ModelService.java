/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.Model;

import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ModelService {

    /**
     * Creates/adds a new model.
     *
     * @param model TODO
     *
     * @return the result
     */
    java.util.UUID createModel(Model model);
        
    /**
     * TODO
     *
     * @param modelId 
     *
     * @return the result
     */
    Model getModelById(java.util.UUID modelId);
        
}
