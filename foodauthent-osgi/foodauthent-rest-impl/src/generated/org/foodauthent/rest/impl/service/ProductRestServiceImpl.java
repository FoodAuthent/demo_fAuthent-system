/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.Product;
import org.foodauthent.model.ProductPageResult;

import org.foodauthent.api.ProductService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.ProductRestService;

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
public class ProductRestServiceImpl implements ProductRestService {

    private final ProductService service = ServiceRegistry.get(ProductService.class);


    /**
     * TODO
     *
     * @param product TODO
     * @return the response
     */
    public Response createProduct(Product product) {
        
            Object res = service.createProduct(product);
            return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param gtin TODO
     * @return the response
     */
    public Response findProductByGtin(String gtin) {
        
            Object res = service.findProductByGtin(gtin);
            return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findProductByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findProductByKeyword(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param gtin 
     * @return the response
     */
    public Response removeProductByGtin(java.util.UUID gtin) {
        
            service.removeProductByGtin(gtin);
            
                return Response.ok().build();
    }

    /**
     * TODO
     *
     * @param product TODO
     * @return the response
     */
    public Response updatedProduct(Product product) {
        
            service.updatedProduct(product);
            
                return Response.ok().build();
    }
}

