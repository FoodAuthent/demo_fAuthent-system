package org.foodauthent.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.foodauthent.model.Product;
import org.foodauthent.model.ProductPageResult;
import org.foodauthent.rest.api.service.ProductRestService;
import org.junit.Test;

/**
 * Test case for Products
 *
 * @author Massimo Bevilacqua
 * 
 * TEST OK
 *
 */

public class ProductTest extends AbstractITTest{
    @Test
    public void test() {
	boolean idExists = false;
	
	ProductRestService s = restService(ProductRestService.class);
	ProductPageResult productPage = s.findProductByKeyword(1, 10, null).readEntity(ProductPageResult.class);
	assertEquals(1, productPage.getPageNumber().intValue());
	assertEquals(10, productPage.getResults().size());
	
	//Retrive all the products
	List<Product> allProducts = s.findProductByKeyword(1, 10000, Collections.emptyList()).readEntity(ProductPageResult.class).getResults();
	
	//check if my test product already exists and if doesn't exist it adds product
	idExists = allProducts.stream().anyMatch(t -> t.getBrand().equals("TestBrand2"));	
	if(!idExists) {   
	Product p0 = Product.builder().setBrand("TestBrand2").setFaId(UUID.randomUUID()).setGtin("0000000000002").build();
	s.createProduct(p0);
	}
	
	//retrieve the test product
	productPage = s.findProductByKeyword(1, 3, Arrays.asList("TestBrand2")).readEntity(ProductPageResult.class);
	assertEquals(1, productPage.getPageNumber().intValue());
	assertEquals(2, productPage.getResults().size());
	assertEquals(2, productPage.getResultCount().intValue());
	
	//Test Delete
	s.removeProductById(UUID.fromString("45cceda9-e54b-4b1d-9b94-c269b5f5cac7"));
	allProducts = s.findProductByKeyword(1, 10000, Collections.emptyList()).readEntity(ProductPageResult.class).getResults();
	idExists = allProducts.stream().anyMatch(t -> t.getBrand().equals("TestBrand2"));
	assertFalse(idExists);
	
    }

}
