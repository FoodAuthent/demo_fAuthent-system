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
     * @param modelId 
     * @param schemaId 
     * @param faId 
     *
     * @return the result
     */
    String getCustomMetadata(String modelId, String schemaId, java.util.UUID faId);
        
    /**
     * TODO
     *
     * @param modelId 
     * @param schemaId 
     *
     * @return the result
     */
    String getCustomMetadataSchema(String modelId, String schemaId);
        
    /**
     * TODO
     *
     * @param modelId 
     *
     * @return the result
     */
    java.util.List<String> getCustomMetadataSchemas(String modelId);
        
    /**
     * TODO
     *
     * @param modelId 
     * @param schemaId 
     * @param faId 
     * @param body 
     *
     * 
     */
    void saveCustomMetadata(String modelId, String schemaId, java.util.UUID faId, String body);
        
}
