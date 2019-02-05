/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.UserAuthenticationRequest;

import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface AuthenticationService {

    /**
     * TODO
     *
     * @param userAuthenticationRequest TODO
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws FAException Unspecified exception.
     */
    String authenticateUserJSONWebToken(UserAuthenticationRequest userAuthenticationRequest) throws FAExceptions.UnauthorizedResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param body User&#39;s JSON Web Token to refresh
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws FAException Unspecified exception.
     */
    String refreshJSONWebToken(String body) throws FAExceptions.UnauthorizedResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param body JWT token to be verfied
     *
     * 
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws FAException Unspecified exception.
     */
    void verifyJSONWebToken(String body) throws FAExceptions.UnauthorizedResponse, FAExceptions.FAException;
        
}
