package org.foodauthent.impl.file;

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
    public FaObjectSet importData(File file) {

	List<Fingerprint> fingerprints = new ArrayList<>();
	List<Product> products = new ArrayList<>();
	List<SOP> sops = new ArrayList<>();

	ZipFile zipFile;
	try {
	    zipFile = new ZipFile(file);
	    Enumeration<? extends ZipEntry> entries = zipFile.entries();

	    while (entries.hasMoreElements()) {
		ZipEntry entry = entries.nextElement();

		if (entry.getName().startsWith("fingerprints/")) {
		    try (InputStream stream = zipFile.getInputStream(entry)) {
			fingerprints.add(MAPPER.readValue(stream, Fingerprint.class));
		    }
		} else if (entry.getName().startsWith("products/")) {
		    try (InputStream stream = zipFile.getInputStream(entry)) {
			products.add(MAPPER.readValue(stream, Product.class));
		    }
		} else if (entry.getName().startsWith("sops/")) {
		    try (InputStream stream = zipFile.getInputStream(entry)) {
			sops.add(MAPPER.readValue(stream, SOP.class));
		    }
		}
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
