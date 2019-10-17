/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import org.foodauthent.auth.security.SecurityScheme;

import org.foodauthent.model.ChangePasswordRequest;
import org.foodauthent.model.User;
import org.foodauthent.model.UserBase;
import org.foodauthent.model.UserCreateRequest;
import org.foodauthent.model.UserGroup;
import org.foodauthent.model.UserGroupBase;
import org.foodauthent.model.UserGroupCreateRequest;

import org.foodauthent.api.UserService;
import org.foodauthent.api.ServiceRegistry;

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
@Path("/v0/foodauthent")
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface UserRestService{


    /**
     * TODO
     *
     * @param userCreateRequest TODO
     * @return the response
     */
    @POST
    @Path("/user")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "text/plain" })
    public Response createUser(UserCreateRequest userCreateRequest
);

    /**
     * TODO
     *
     * @param userGroupCreateRequest TODO
     * @return the response
     */
    @POST
    @Path("/user/group")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Consumes({ "application/json" })
    @Produces({ "application/json", "text/plain" })
    public Response createUserGroup(UserGroupCreateRequest userGroupCreateRequest
);

    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     * @return the response
     */
    @DELETE
    @Path("/user/{dn}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "text/plain" })
    public Response deleteUser(@PathParam("dn") String dn
);

    /**
     * TODO
     *
     * @param dn The user group&#39;s LDAP dn
     * @return the response
     */
    @DELETE
    @Path("/user/group/{dn}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "text/plain" })
    public Response deleteUserGroup(@PathParam("dn") String dn
);

    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     * @param length length of generated password
     * @return the response
     */
    @GET
    @Path("/user/{dn}/pwgen")
    @Produces({ "text/plain" })
    public Response generatePassword(@PathParam("dn") String dn
, @QueryParam("length")Integer length
);

    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     * @return the response
     */
    @GET
    @Path("/user/{dn}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json", "text/plain" })
    public Response getUser(@PathParam("dn") String dn
);

    /**
     * TODO
     *
     * @param dn The user group&#39;s LDAP dn
     * @return the response
     */
    @GET
    @Path("/user/group/{dn}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json", "text/plain" })
    public Response getUserGroup(@PathParam("dn") String dn
);

    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     * @param changePasswordRequest TODO
     * @return the response
     */
    @POST
    @Path("/user/{dn}/pwset")
    @Consumes({ "application/json" })
    @Produces({ "text/plain" })
    public Response setPassword(@PathParam("dn") String dn
, ChangePasswordRequest changePasswordRequest
);

    /**
     * TODO
     *
     * @param dn The user&#39;s LDAP dn
     * @param userBase TODO
     * @return the response
     */
    @PUT
    @Path("/user/{dn}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Consumes({ "application/json" })
    @Produces({ "application/json", "text/plain" })
    public Response updateUser(@PathParam("dn") String dn
, UserBase userBase
);

    /**
     * TODO
     *
     * @param dn The user group&#39;s LDAP dn
     * @param userGroupBase TODO
     * @return the response
     */
    @PUT
    @Path("/user/group/{dn}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Consumes({ "application/json" })
    @Produces({ "application/json", "text/plain" })
    public Response updateUserGroup(@PathParam("dn") String dn
, UserGroupBase userGroupBase
);
}

