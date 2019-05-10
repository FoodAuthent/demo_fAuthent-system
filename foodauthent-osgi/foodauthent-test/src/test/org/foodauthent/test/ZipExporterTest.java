package org.foodauthent.test;

import static org.foodauthent.rest.client.FASystemClient.files;
import static org.foodauthent.rest.client.FASystemClient.products;
import static org.foodauthent.rest.client.FASystemClient.sops;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.Response;

import org.foodauthent.model.FaObjectSet;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;
import org.junit.Test;

public class ZipExporterTest extends AbstractITTest {

    @Test
    public void test() throws IOException {

	// 1. Create and upload a product
	Product product = Product.builder().setBrand("Krusty Burger").setGtin("0123456789").build();
	products().createProduct(product);

	// 2. Create and upload an SOP
	SOP sop = SOP.builder().setName("best_sop").setDescription("Exclusive to Krusty Burger")
		.setFileId(UUID.randomUUID()).setProductId(UUID.randomUUID()).build();
	sops().createNewSOP(sop);

	// 3. Create FaObjectSet with ids
	List<UUID> productIds = Arrays.asList(product.getFaId());
	List<UUID> sopIds = Arrays.asList(sop.getFaId());
	FaObjectSet objectSet = FaObjectSet.builder().setProducts(productIds).setSops(sopIds).build();

	// 4. Create temporary file
	File tempFile = File.createTempFile("export", ".zip");
	tempFile.deleteOnExit();
	
	//Add file UUID for the URL
	UUID fileId = UUID.randomUUID();

	// 5. Export product and SOP to temporary file
	Response response = files().exportFile("zip",fileId, objectSet);
	
	// 6. Check response
	assertNotNull(response);
	assertEquals(200, response.getStatus());
    }

}
