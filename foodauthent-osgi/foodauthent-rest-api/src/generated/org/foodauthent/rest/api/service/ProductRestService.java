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
     * Muliple keywords can be provided with comma separated strings, e.g, keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 1
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
     * Gets product by id.
     *
     * @param productId The id to get the product for.
     * @return the response
     */
    @GET
    @Path("/product/{product-id}")
    @Produces({ "application/json" })
    public Response getProductById(@PathParam("product-id") java.util.UUID productId
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

