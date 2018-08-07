/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.Model;
import org.foodauthent.model.ModelPageResult;

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
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber 
     * @param pageSize 
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    ModelPageResult findModelByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * TODO
     *
     * @param modelId 
     *
     * @return the result
     */
    Model getModelById(java.util.UUID modelId);
        
}
