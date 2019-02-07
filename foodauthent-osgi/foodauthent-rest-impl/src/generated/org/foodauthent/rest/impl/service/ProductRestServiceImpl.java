/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

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
@Component(service = ProductRestService.class, immediate = true)
public class ProductRestServiceImpl implements ProductRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private ProductService service;


    /**
     * Create a new product entity.
     *
     * @param product TODO
     * @return the response
     */
    public Response createProduct(Product product) {
        
            Object res = service.createProduct(product);
            return Response.ok(res).build();
    }

    /**
     * Find product by gtin.
     *
     * @param gtin The gtin to find the product for.
     * @return the response
     */
    public Response findProductByGtin(String gtin) {
        
            Object res = service.findProductByGtin(gtin);
            return Response.ok(res).build();
    }

    /**
     * Muliple keywords can be provided with comma separated strings, e.g, keyword1, keyword2.
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
     * Delete a product specified by gtin.
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

