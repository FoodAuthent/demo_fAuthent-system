/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import org.foodauthent.model.Organization;
import org.foodauthent.model.OrganizationBase;
import org.foodauthent.model.OrganizationCreateRequest;

import org.foodauthent.api.OrganizationService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.OrganizationRestService;

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
@Component(service = OrganizationRestService.class, immediate = true)
public class OrganizationRestServiceImpl implements OrganizationRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private OrganizationService service;


    /**
     * TODO
     *
     * @param organizationCreateRequest TODO
     * @return the response
     */
    public Response createOrganization(OrganizationCreateRequest organizationCreateRequest) {
        try { 
            Object res = service.createOrganization(organizationCreateRequest);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.EntityAlreadyExistsResponse e) {
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
     * @param dn The organization&#39;s LDAP dn
     * @return the response
     */
    public Response deleteOrganization(String dn) {
        try { 
            service.deleteOrganization(dn);
            
                return Response.ok().build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.EntityNotFoundResponse e) {
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
     * @param dn The organization&#39;s LDAP dn
     * @return the response
     */
    public Response getOrganization(String dn) {
        try { 
            Object res = service.getOrganization(dn);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.EntityNotFoundResponse e) {
           return Response.status(404).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * TODO
     *
     * @param dn The organization&#39;s LDAP dn
     * @param organizationBase TODO
     * @return the response
     */
    public Response updateOrganization(String dn, OrganizationBase organizationBase) {
        try { 
            Object res = service.updateOrganization(dn, organizationBase);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.UnauthorizedResponse e) {
           return Response.status(401).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.ForbiddenAccessResponse e) {
           return Response.status(403).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.EntityNotFoundResponse e) {
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

