package org.foodauthent.data;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.foodauthent.data.FASystem.products;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.foodauthent.model.Product;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public class PopulateProducts {
    
    private PopulateProducts() {
	//utility class
    }
    
    public static List<UUID> populateRandomProducts(int numProducts) {
	return IntStream.range(0, numProducts).mapToObj(i -> {
	    Product p = Product.builder().setBrand(randomAlphabetic(5)).setGtin(randomAlphabetic(5))
		    .setComment(randomAlphabetic(5)).setCompanyName(randomAlphabetic(5)).build();
	    return products().createProduct(p).readEntity(UUID.class);
	}).collect(Collectors.toList());
    }

}
