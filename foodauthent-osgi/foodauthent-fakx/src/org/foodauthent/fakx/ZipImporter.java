package org.foodauthent.fakx;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.foodauthent.model.Product;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Import components from a ZIP file.
 * 
 * A ZIP file contains a number of products within a 'products' folder with
 * multiple json files named with the id of the product they describe.
 * 
 * @author Miguel de Alba
 */
public class ZipImporter implements ImporterI {

	public List<Product> importProducts(File file) {

		List<Product> products = new ArrayList<>();

		ZipFile zipFile;
		try {
			zipFile = new ZipFile(file);
			Enumeration<? extends ZipEntry> entries = zipFile.entries();

			ObjectMapper mapper = new ObjectMapper();

			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();

				if (entry.getName().startsWith("products/")) {
					try (InputStream stream = zipFile.getInputStream(entry)) {
						Product product = mapper.readValue(stream, Product.class);
						products.add(product);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
	}
}
