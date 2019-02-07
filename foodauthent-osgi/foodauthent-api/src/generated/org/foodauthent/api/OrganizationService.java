/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.Organization;
import org.foodauthent.model.OrganizationBase;
import org.foodauthent.model.OrganizationCreateRequest;

import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface OrganizationService {

    /**
     * TODO
     *
     * @param organizationCreateRequest TODO
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelAlreadyExistsResponse Invalid input was provided, model already exists.
     * @throws InvalidOperationResponse Requested operation is not supported.
     * @throws FAException Unspecified exception.
     */
    Organization createOrganization(OrganizationCreateRequest organizationCreateRequest) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelAlreadyExistsResponse, FAExceptions.InvalidOperationResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param dn The organization&#39;s LDAP dn
     *
     * 
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelNotFoundResponse Response thrown when an model could not be found.
     * @throws InvalidOperationResponse Requested operation is not supported.
     * @throws FAException Unspecified exception.
     */
    void deleteOrganization(String dn) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.InvalidOperationResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param dn The organization&#39;s LDAP dn
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelNotFoundResponse Response thrown when an model could not be found.
     * @throws FAException Unspecified exception.
     */
    Organization getOrganization(String dn) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.FAException;
        
    /**
     * TODO
     *
     * @param dn The organization&#39;s LDAP dn
     * @param organizationBase TODO
     *
     * @return the result
     * @throws UnauthorizedResponse Unauthorized access.
     * @throws ForbiddenAccessResponse Access to resource is not allowed.
     * @throws ModelNotFoundResponse Response thrown when an model could not be found.
     * @throws InvalidOperationResponse Requested operation is not supported.
     * @throws FAException Unspecified exception.
     */
    Organization updateOrganization(String dn, OrganizationBase organizationBase) throws FAExceptions.UnauthorizedResponse, FAExceptions.ForbiddenAccessResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.InvalidOperationResponse, FAExceptions.FAException;
        
}
