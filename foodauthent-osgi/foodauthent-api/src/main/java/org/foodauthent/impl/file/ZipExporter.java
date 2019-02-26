package org.foodauthent.impl.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.model.FaModel;
import org.foodauthent.model.FaObjectSet;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Export FoodAuthent components to a ZIP file.
 * 
 * <p>
 * The ZIP files contains multiple JSON files named with the id of the
 * FoodAuthent components they describe. These files are sorted into the
 * subfolders:
 * <ul>
 * <li>'products' with {@link Product}
 * <li>'sops' with {@link SOP}
 * </ul>
 * </p>
 * 
 * @author Miguel de Alba
 */
public class ZipExporter implements Exporter {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final PersistenceService service;

    public ZipExporter(PersistenceService service) {
	this.service = service;
    }

    @Override
    public void export(FaObjectSet objectSet, File file) {

	try (FileOutputStream fileOutStream = new FileOutputStream(file);
		ZipOutputStream zipOutStream = new ZipOutputStream(fileOutStream)) {

	    // TODO: fingerprints
	    addProducts(zipOutStream, objectSet.getProducts());
	    addSops(zipOutStream, objectSet.getSops());
	    // TODO: workflows
	    // TODO: files

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    private void addProducts(ZipOutputStream stream, List<UUID> uuids) {

	for (UUID id : uuids) {
	    String entryName = "products/" + id + ".json";
	    Product product = service.getProductById(id);
	    writeBytes(stream, entryName, product);
	}
    }

    private void addSops(ZipOutputStream stream, List<UUID> uuids) {

	for (UUID id : uuids) {
	    String entryName = "sops/" + id + ".json";
	    // I had to copy this line from SopServiceImpl. Maybe there is a better way to
	    // resuse SopServiceImpl#getSOPById
	    SOP sop = service.getFaModelByUUID(id, SOP.class);
	    writeBytes(stream, entryName, sop);
	}
    }

    private void writeBytes(ZipOutputStream stream, String entryName, FaModel model) {
	try {
	    stream.putNextEntry(new ZipEntry(entryName));
	    byte[] bytes = MAPPER.writeValueAsBytes(model);
	    stream.write(bytes);
	    stream.closeEntry();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
