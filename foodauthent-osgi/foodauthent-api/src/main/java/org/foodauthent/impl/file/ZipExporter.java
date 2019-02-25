package org.foodauthent.impl.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.foodauthent.api.ProductService;
import org.foodauthent.api.SopService;
import org.foodauthent.impl.product.ProductServiceImpl;
import org.foodauthent.impl.sop.SopServiceImpl;
import org.foodauthent.model.FaObjectSet;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ZipExporter implements Exporter {
    
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public void export(FaObjectSet objectSet, File file) {

	// TODO: export

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

    private static void addProducts(ZipOutputStream stream, List<UUID> uuids) {

	ProductService service = new ProductServiceImpl();

	for (UUID id : uuids) {
	    String entryName = "products/" + id + ".json";
	    try {
		Product product = service.getProductById(id);
		
		stream.putNextEntry(new ZipEntry(entryName));
		byte[] bytes = MAPPER.writeValueAsBytes(product);
		stream.write(bytes);
		stream.closeEntry();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
    
    private static void addSops(ZipOutputStream stream, List<UUID> uuids) {

	SopService service = new SopServiceImpl();

	for (UUID id : uuids) {
	    String entryName = "sops/" + id + ".json";
	    try {
		SOP sop = service.getSOPById(id);
		
		stream.putNextEntry(new ZipEntry(entryName));
		byte[] bytes = MAPPER.writeValueAsBytes(sop);
		stream.write(bytes);
		stream.closeEntry();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
}
