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
public interface CustomMetadataService {

    /**
     * TODO
     *
     * @param modelType 
     * @param schemaId 
     * @param faId 
     *
     * @return the result
     */
    String getCustomMetadata(String modelType, String schemaId, java.util.UUID faId);
        
    /**
     * TODO
     *
     * @param modelType 
     * @param schemaId 
     *
     * @return the result
     */
    String getCustomMetadataSchema(String modelType, String schemaId);
        
    /**
     * TODO
     *
     * @param modelType 
     *
     * @return the result
     */
    java.util.List<String> getCustomMetadataSchemas(String modelType);
        
    /**
     * TODO
     *
     * @param modelType 
     * @param schemaId 
     * @param faId 
     * @param body 
     *
     * 
     */
    void saveCustomMetadata(String modelType, String schemaId, java.util.UUID faId, String body);
        
}
