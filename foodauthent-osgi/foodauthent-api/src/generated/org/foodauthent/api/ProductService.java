/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.Product;
import org.foodauthent.model.ProductPageResult;

import org.foodauthent.common.exception.FAExceptions;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ProductService {

    /**
     * Create a new product entity.
     *
     * @param product TODO
     *
     * @return the result
     */
    java.util.UUID createProduct(Product product);
        
    /**
     * Find product by gtin.
     *
     * @param gtin The gtin to find the product for.
     *
     * @return the result
     */
    Product findProductByGtin(String gtin);
        
    /**
     * Find product by id.
     *
     * @param id The id to find the product for.
     *
     * @return the result
     */
    Product findProductById(java.util.UUID id);
        
    /**
     * Muliple keywords can be provided with comma separated strings, e.g, keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    ProductPageResult findProductByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * Delete a product specified by gtin.
     *
     * @param gtin 
     *
     * 
     */
    void removeProductByGtin(java.util.UUID gtin);
        
    /**
     * TODO
     *
     * @param product TODO
     *
     * 
     */
    void updatedProduct(Product product);
        
}
