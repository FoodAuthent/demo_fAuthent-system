/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import org.foodauthent.auth.security.SecurityScheme;

import org.foodauthent.model.Organization;
import org.foodauthent.model.OrganizationBase;
import org.foodauthent.model.OrganizationCreateRequest;

import org.foodauthent.api.OrganizationService;
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
public interface OrganizationRestService{


    /**
     * TODO
     *
     * @param organizationCreateRequest TODO
     * @return the response
     */
    @POST
    @Path("/organization")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Consumes({ "application/json" })
    @Produces({ "application/json", "text/plain" })
    public Response createOrganization(OrganizationCreateRequest organizationCreateRequest
);

    /**
     * TODO
     *
     * @param dn The organization&#39;s LDAP dn
     * @return the response
     */
    @DELETE
    @Path("/organization/{dn}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "text/plain" })
    public Response deleteOrganization(@PathParam("dn") String dn
);

    /**
     * TODO
     *
     * @param dn The organization&#39;s LDAP dn
     * @return the response
     */
    @GET
    @Path("/organization/{dn}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json", "text/plain" })
    public Response getOrganization(@PathParam("dn") String dn
);

    /**
     * TODO
     *
     * @param dn The organization&#39;s LDAP dn
     * @param organizationBase TODO
     * @return the response
     */
    @PUT
    @Path("/organization/{dn}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Consumes({ "application/json" })
    @Produces({ "application/json", "text/plain" })
    public Response updateOrganization(@PathParam("dn") String dn
, OrganizationBase organizationBase
);
}

