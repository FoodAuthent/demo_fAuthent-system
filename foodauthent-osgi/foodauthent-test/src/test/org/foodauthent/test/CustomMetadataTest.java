package org.foodauthent.test;

import static org.foodauthent.rest.client.FASystemClientUtil.customMetadata;
import static org.foodauthent.rest.client.FASystemClientUtil.products;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.foodauthent.model.Product;
import org.foodauthent.rest.client.FASystemClient;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Martin Horn, University of Konstanz
 */

public class CustomMetadataTest extends AbstractITTest {
    
    @Test
    public void testSaveCustomMetadata() throws Exception {
	Product p = Product.builder().setBrand("brand").setGtin("gtin").build();
	UUID productId = products(client()).createProduct(p).readEntity(UUID.class);

	String json = IOUtils.toString(new FileInputStream(new File("files/json/custommetadata_fingerprintset.json")),
		StandardCharsets.UTF_8);

	Response r = customMetadata(client()).saveCustomMetadata("fingerprintset", "foodauthent_v0",
		productId, json);
	assertThat("Unexpected response", 200, is(r.getStatus()));

    }
    
    @Test
    public void testGetCustomMetadataSchemaList() {
	List<String> schemas = customMetadata(client()).getCustomMetadataSchemas("fingerprintset")
		.readEntity(new GenericType<List<String>>() {
		});
	assertThat("Unexpected schema id", "foodauthent_v0", is(schemas.get(0)));
    }

}
