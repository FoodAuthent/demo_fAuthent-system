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
     * TODO
     *
     * @param product TODO
     *
     * @return the result
     */
    java.util.UUID createProduct(Product product);
        
    /**
     * TODO
     *
     * @param gtin TODO
     *
     * @return the result
     */
    Product findProductByGtin(String gtin);
        
    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber 
     * @param pageSize 
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    ProductPageResult findProductByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
}
