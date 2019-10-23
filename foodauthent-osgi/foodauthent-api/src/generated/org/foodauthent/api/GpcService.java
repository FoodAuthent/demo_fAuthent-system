/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.GPCBrickData;

import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface GpcService {

    /**
     * find gpc bricks by filter
     *
     * @param s 
     * @param lang 
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ModelNotFoundResponse Response thrown when an model could not be found.
     * @throws FAException Unspecified exception.
     */
    java.util.List<GPCBrickData> findGpcBricks(String s, String lang) throws FAExceptions.UnauthorizedResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.FAException;
        
}
