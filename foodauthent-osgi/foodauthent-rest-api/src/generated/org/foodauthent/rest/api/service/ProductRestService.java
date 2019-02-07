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
     * Create a new product entity.
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
     * Find product by gtin.
     *
     * @param gtin The gtin to find the product for.
     * @return the response
     */
    @GET
    @Path("/product/findByGtin")
    @Produces({ "application/json" })
    public Response findProductByGtin(@QueryParam("gtin")String gtin
);

    /**
     * Find product by id.
     *
     * @param id The id to find the product for.
     * @return the response
     */
    @GET
    @Path("/product/findById")
    @Produces({ "application/json" })
    public Response findProductById(@QueryParam("id")java.util.UUID id
);

    /**
     * Muliple keywords can be provided with comma separated strings, e.g, keyword1, keyword2.
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
     * Delete a product specified by gtin.
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

