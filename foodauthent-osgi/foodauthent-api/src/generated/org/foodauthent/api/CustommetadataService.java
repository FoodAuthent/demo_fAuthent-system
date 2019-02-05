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
public interface CustommetadataService {

    /**
     * TODO
     *
     * @param entityId 
     * @param schemaId 
     * @param faId 
     *
     * @return the result
     */
    String getCustomMetadata(String entityId, String schemaId, java.util.UUID faId);
        
    /**
     * TODO
     *
     * @param entityId 
     * @param schemaId 
     *
     * @return the result
     */
    String getCustomMetadataSchema(String entityId, String schemaId);
        
    /**
     * TODO
     *
     * @param entityId 
     *
     * @return the result
     */
    java.util.List<String> getCustomMetadataSchemas(String entityId);
        
}
