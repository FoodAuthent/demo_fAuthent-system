/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


import org.foodauthent.api.RelationService;
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
public interface RelationRestService{


    /**
     *
     * @return the response
     */
    @GET
    @Path("/relation/entities")
    @Produces({ "application/json" })
    public Response getEntities();

    /**
     *
     * @param entityName root entity name.
     * @param faId fa-id to match with in referenced entities.
     * @param referencedEntity root entity name.
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @return the response
     */
    @GET
    @Path("/relation/entity/{entity-name}/{fa-id}/{referenced-entity}")
    @Produces({ "application/json" })
    public Response getForeignKeyEntities(@PathParam("entity-name") String entityName
, @PathParam("fa-id") java.util.UUID faId
, @PathParam("referenced-entity") String referencedEntity
, @QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
);

    /**
     *
     * @param entityName root entity name.
     * @return the response
     */
    @GET
    @Path("/relation/entity/{entity-name}")
    @Produces({ "application/json" })
    public Response getSupportedEntities(@PathParam("entity-name") String entityName
);
}

