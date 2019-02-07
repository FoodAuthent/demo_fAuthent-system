package org.foodauthent.fakx;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.foodauthent.model.Product;

public class CreateExample {

	public static void main(String[] args) throws IOException {
		
		Product p1 = Product.builder().setBrand("fake_brand").setGtin("fake_gtin").build();
		Product kellogs = Product.builder().setBrand("Kellogs").setGtin("01010").build();
		List<Product> products = Arrays.asList(p1, kellogs);

		File file = new File("sample.zip");

		Fakx.save(products, file);
	}

}
