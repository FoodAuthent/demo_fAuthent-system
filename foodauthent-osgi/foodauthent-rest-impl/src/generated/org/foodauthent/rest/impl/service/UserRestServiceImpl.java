/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import org.foodauthent.model.ChangePasswordRequest;
import org.foodauthent.model.User;
import org.foodauthent.model.UserBase;
import org.foodauthent.model.UserCreateRequest;
import org.foodauthent.model.UserGroup;
import org.foodauthent.model.UserGroupBase;
import org.foodauthent.model.UserGroupCreateRequest;

import org.foodauthent.api.UserService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.UserRestService;

import org.foodauthent.common.exception.FAExceptions;

/**
 * FoodAuthent Swagger API
 *
 * <p>This is the FoodAuthent API Description [www.foodauthent.net]
 *
 * <p> 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
@Component(service = UserRestService.class, immediate = true)
public class UserRestServiceImpl implements UserRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private UserService service;


    /**
     * TODO
     *
     * @param userCreateRequest TODO
     * @return the response
     */
    public Response createUser(UserCreateRequest userCreateRequest) {
        try { 
            Object res = service.createUser(userCreateRequest);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ModelAlreadyExistsResponse e) {
           return Response.status(409).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.InvalidOperationResponse e) {
           return Response.status(415).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * TODO
     *
     * @param userGroupCreateRequest TODO
     * @return the response
     */
    public Response createUserGroup(UserGroupCreateRequest userGroupCreateRequest) {
        try { 
            Object res = service.createUserGroup(userGroupCreateRequest);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ModelAlreadyExistsResponse e) {
           return Response.status(409).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.InvalidOperationResponse e) {
           return Response.status(415).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     * @return the response
     */
    public Response deleteUser(String dn) {
        try { 
            service.deleteUser(dn);
            
                return Response.ok().build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ModelNotFoundResponse e) {
           return Response.status(404).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.InvalidOperationResponse e) {
           return Response.status(415).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * TODO
     *
     * @param dn The user group&#39;s LDAP dn
     * @return the response
     */
    public Response deleteUserGroup(String dn) {
        try { 
            service.deleteUserGroup(dn);
            
                return Response.ok().build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ModelNotFoundResponse e) {
           return Response.status(404).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.InvalidOperationResponse e) {
           return Response.status(415).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     * @param length length of generated password
     * @return the response
     */
    public Response generatePassword(String dn, Integer length) {
        try { 
            Object res = service.generatePassword(dn, length);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ModelNotFoundResponse e) {
           return Response.status(404).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     * @return the response
     */
    public Response getUser(String dn) {
        try { 
            Object res = service.getUser(dn);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ModelNotFoundResponse e) {
           return Response.status(404).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * TODO
     *
     * @param dn The user group&#39;s LDAP dn
     * @return the response
     */
    public Response getUserGroup(String dn) {
        try { 
            Object res = service.getUserGroup(dn);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ModelNotFoundResponse e) {
           return Response.status(404).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     * @param changePasswordRequest TODO
     * @return the response
     */
    public Response setPassword(String dn, ChangePasswordRequest changePasswordRequest) {
        try { 
            service.setPassword(dn, changePasswordRequest);
            
                return Response.ok().build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ModelNotFoundResponse e) {
           return Response.status(404).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     * @param userBase TODO
     * @return the response
     */
    public Response updateUser(String dn, UserBase userBase) {
        try { 
            Object res = service.updateUser(dn, userBase);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ModelNotFoundResponse e) {
           return Response.status(404).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.InvalidOperationResponse e) {
           return Response.status(415).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * TODO
     *
     * @param dn The user group&#39;s LDAP dn
     * @param userGroupBase TODO
     * @return the response
     */
    public Response updateUserGroup(String dn, UserGroupBase userGroupBase) {
        try { 
            Object res = service.updateUserGroup(dn, userGroupBase);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ModelNotFoundResponse e) {
           return Response.status(404).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.InvalidOperationResponse e) {
           return Response.status(415).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }
}

