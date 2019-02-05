/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.Product;
import org.foodauthent.model.ProductPageResult;

import org.foodauthent.api.ProductService;
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
public interface ProductRestService{


    /**
     * TODO
     *
     * @param product TODO
     * @return the response
     */
    @POST
    @Path("/product")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createProduct(Product product
);

    /**
     * TODO
     *
     * @param gtin TODO
     * @return the response
     */
    @GET
    @Path("/product/findByGtin")
    @Produces({ "application/json" })
    public Response findProductByGtin(@QueryParam("gtin")String gtin
);

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/product")
    @Produces({ "application/json" })
    public Response findProductByKeyword(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * TODO
     *
     * @param gtin 
     * @return the response
     */
    @DELETE
    @Path("/product/{gtin}")
    public Response removeProductByGtin(@PathParam("gtin") java.util.UUID gtin
);

    /**
     * TODO
     *
     * @param product TODO
     * @return the response
     */
    @PUT
    @Path("/product")
    @Consumes({ "application/json" })
    public Response updatedProduct(Product product
);
}

