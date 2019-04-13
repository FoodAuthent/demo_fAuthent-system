/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.SystemInfo;

import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface InfoService {

    /**
     * statistics and status
     *
     *
     * @return the result
     */
    SystemInfo getInfo();
        
}
