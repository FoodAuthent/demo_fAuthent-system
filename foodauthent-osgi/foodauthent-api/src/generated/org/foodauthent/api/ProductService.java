/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.Product;

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
        
}
