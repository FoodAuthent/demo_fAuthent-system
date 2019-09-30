/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.Model;
import org.foodauthent.model.ModelPageResult;
import org.foodauthent.model.ObjectEvent;
import org.foodauthent.model.PublishMetadata;

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
     * Muliple keywords can be provided with comma separated strings, e.g. keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
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
        
    /**
     * TODO
     *
     * @param modelId 
     * @param publishMetadata TODO
     *
     * @return the result
     */
    ObjectEvent publishModelById(java.util.UUID modelId, PublishMetadata publishMetadata);
        
    /**
     * TODO
     *
     * @param model TODO
     *
     * 
     */
    void updatedModel(Model model);
        
}
