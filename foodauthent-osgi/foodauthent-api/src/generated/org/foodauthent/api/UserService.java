/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.ChangePasswordRequest;
import org.foodauthent.model.User;
import org.foodauthent.model.UserBase;
import org.foodauthent.model.UserCreateRequest;
import org.foodauthent.model.UserGroup;
import org.foodauthent.model.UserGroupBase;
import org.foodauthent.model.UserGroupCreateRequest;

import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface UserService {

    /**
     * TODO
     *
     * @param userCreateRequest TODO
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelAlreadyExistsResponse Invalid input was provided, model already exists.
     * @throws InvalidOperationResponse Requested operation is not supported.
     * @throws FAException Unspecified exception.
     */
    User createUser(UserCreateRequest userCreateRequest) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelAlreadyExistsResponse, FAExceptions.InvalidOperationResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param userGroupCreateRequest TODO
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelAlreadyExistsResponse Invalid input was provided, model already exists.
     * @throws InvalidOperationResponse Requested operation is not supported.
     * @throws FAException Unspecified exception.
     */
    UserGroup createUserGroup(UserGroupCreateRequest userGroupCreateRequest) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelAlreadyExistsResponse, FAExceptions.InvalidOperationResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     *
     * 
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelNotFoundResponse Response thrown when an model could not be found.
     * @throws InvalidOperationResponse Requested operation is not supported.
     * @throws FAException Unspecified exception.
     */
    void deleteUser(String dn) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.InvalidOperationResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param dn The user group&#39;s LDAP dn
     *
     * 
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelNotFoundResponse Response thrown when an model could not be found.
     * @throws InvalidOperationResponse Requested operation is not supported.
     * @throws FAException Unspecified exception.
     */
    void deleteUserGroup(String dn) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.InvalidOperationResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     * @param length length of generated password
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelNotFoundResponse Response thrown when an model could not be found.
     * @throws FAException Unspecified exception.
     */
    String generatePassword(String dn, Integer length) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelNotFoundResponse Response thrown when an model could not be found.
     * @throws FAException Unspecified exception.
     */
    User getUser(String dn) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param dn The user group&#39;s LDAP dn
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelNotFoundResponse Response thrown when an model could not be found.
     * @throws FAException Unspecified exception.
     */
    UserGroup getUserGroup(String dn) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     * @param changePasswordRequest TODO
     *
     * 
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelNotFoundResponse Response thrown when an model could not be found.
     * @throws FAException Unspecified exception.
     */
    void setPassword(String dn, ChangePasswordRequest changePasswordRequest) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     * @param userBase TODO
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelNotFoundResponse Response thrown when an model could not be found.
     * @throws InvalidOperationResponse Requested operation is not supported.
     * @throws FAException Unspecified exception.
     */
    User updateUser(String dn, UserBase userBase) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.InvalidOperationResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param dn The user group&#39;s LDAP dn
     * @param userGroupBase TODO
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelNotFoundResponse Response thrown when an model could not be found.
     * @throws InvalidOperationResponse Requested operation is not supported.
     * @throws FAException Unspecified exception.
     */
    UserGroup updateUserGroup(String dn, UserGroupBase userGroupBase) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.InvalidOperationResponse, FAExceptions.FAException;
        
}
