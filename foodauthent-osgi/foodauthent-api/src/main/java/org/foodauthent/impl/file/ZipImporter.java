package org.foodauthent.impl.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.model.FaObjectSet;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Import components from a ZIP file.
 * 
 * <p>
 * The ZIP files contains multiple JSON files named with the id of the
 * FoodAuthent components they describe. These files are sorted into the
 * subfolders:
 * <ul>
 * <li>'products' with {@link Product}
 * <li>'sops' with {@link SOP}
 * <li>'fingerprints' with {@link Fingerprint}
 * </ul>
 * </p>
 * 
 * @author Miguel de Alba
 */
public class ZipImporter implements Importer {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final PersistenceService service;

    public ZipImporter(PersistenceService service) {
	this.service = service;
    }

    @Override
    public FaObjectSet importData(InputStream stream) {

	List<Fingerprint> fingerprints = new ArrayList<>();
	List<Product> products = new ArrayList<>();
	List<SOP> sops = new ArrayList<>();

	ZipInputStream zipStream = new ZipInputStream(stream);

	ZipEntry entry;
	try {
	    while ((entry = zipStream.getNextEntry()) != null) {
		// process zip entry
		if (entry.getName().startsWith("fingerprints/")) {
		    Fingerprint fingerprint = MAPPER.readValue(zipStream, Fingerprint.class);
		    fingerprints.add(fingerprint);
		} else if (entry.getName().startsWith("products/")) {
		    Product product = MAPPER.readValue(zipStream, Product.class);
		    products.add(product);
		} else if (entry.getName().startsWith("sops/")) {
		    SOP sop = MAPPER.readValue(zipStream, SOP.class);
		    sops.add(sop);
		}

		zipStream.closeEntry();
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	// Add components to FoodAuthent
	fingerprints.forEach(service::save);
	products.forEach(service::save);
	sops.forEach(service::save);

	// Collect ids in a FaObjectSet
	List<UUID> fingerprintIds = fingerprints.stream().map(Fingerprint::getFaId).collect(Collectors.toList());
	List<UUID> productIds = products.stream().map(Product::getFaId).collect(Collectors.toList());
	List<UUID> sopIds = sops.stream().map(SOP::getFaId).collect(Collectors.toList());

	FaObjectSet objectSet = FaObjectSet.builder().setFingerprints(fingerprintIds).setProducts(productIds)
		.setSops(sopIds).build();
	return objectSet;
    }
}
