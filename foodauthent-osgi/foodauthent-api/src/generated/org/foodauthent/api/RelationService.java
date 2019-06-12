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
public interface RelationService {

    /**
     * 
     *
     *
     * @return the result
     */
    java.util.List<String> getEntities();
        
    /**
     * 
     *
     * @param entityName root entity name.
     * @param faId fa-id to match with in referenced entities.
     * @param referencedEntity root entity name.
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     *
     * @return the result
     */
    Object getForeignKeyEntities(String entityName, java.util.UUID faId, String referencedEntity, Integer pageNumber, Integer pageSize);
        
    /**
     * 
     *
     * @param entityName root entity name.
     *
     * @return the result
     */
    java.util.List<String> getSupportedEntities(String entityName);
        
}
