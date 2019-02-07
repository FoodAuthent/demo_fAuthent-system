package org.foodauthent.impl.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.foodauthent.impl.product.ProductServiceImpl;
import org.foodauthent.impl.sop.SopServiceImpl;
import org.foodauthent.model.FaObjectSet;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;

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

    @Override
    public FaObjectSet importData(File file) {
	
	List<Product> products = new ArrayList<>();
	List<SOP> sops = new ArrayList<>();
	
	ZipFile zipFile;
	try {
	    zipFile = new ZipFile(file);
	    Enumeration<? extends ZipEntry> entries = zipFile.entries();

	    ObjectMapper mapper = new ObjectMapper();

	    while (entries.hasMoreElements()) {
		ZipEntry entry = entries.nextElement();

		if (entry.getName().startsWith("products/")) {
		    try (InputStream stream = zipFile.getInputStream(entry)) {
			products.add(mapper.readValue(stream, Product.class));
		    }
		} else if (entry.getName().startsWith("sops/")) {
		    try (InputStream stream = zipFile.getInputStream(entry)) {
			sops.add(mapper.readValue(stream, SOP.class));
		    }
		}
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	// Add components to FoodAuthent
	ProductServiceImpl productService = new ProductServiceImpl();
	products.forEach(productService::createProduct);

	SopServiceImpl sopService = new SopServiceImpl();
	sops.forEach(sopService::createNewSOP);
	
	// Collect ids in a FaObjectSet
	List<UUID> productIds = products.stream().map(Product::getFaId).collect(Collectors.toList());
	List<UUID> sopIds = sops.stream().map(SOP::getFaId).collect(Collectors.toList());
	
	FaObjectSet objectSet = FaObjectSet.builder().setProducts(productIds).setSops(sopIds).build();
	return objectSet;
    }
}
