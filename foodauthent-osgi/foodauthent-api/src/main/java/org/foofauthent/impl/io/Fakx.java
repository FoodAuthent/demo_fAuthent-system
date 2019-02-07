package org.foofauthent.impl.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.foodauthent.model.Product;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Fakx {
	
	/**
	 * @deprecated Use {@link ImporterI#importProducts(File)} instead
	 */
	@Deprecated
	public static List<Product> importProducts(ZipFile file) {
		List<Product> products = new ArrayList<>();
		
		ObjectMapper mapper = new ObjectMapper();
		
		Enumeration<? extends ZipEntry> entries = file.entries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			if (entry.getName().startsWith("products/")) {
				try (InputStream stream = file.getInputStream(entry)) {
					Product product = mapper.readValue(stream, Product.class);
					products.add(product);
				} catch (IOException e) {
				}
			}
		}
		
		return products;
	}
	
	public static void save(List<Product> products, File file) {
		file.delete();
		
		try (FileOutputStream fileOutStream = new FileOutputStream(file);
				ZipOutputStream zipOutStream = new ZipOutputStream(fileOutStream)) {
			
			ObjectMapper mapper = new ObjectMapper();
			
			for (Product product : products) {
				String entryName = "products/" + product.getFaId() + ".json";
				zipOutStream.putNextEntry(new ZipEntry(entryName));
				
				byte[] lovelyBytes = mapper.writeValueAsBytes(product);
				zipOutStream.write(lovelyBytes);
						
//				mapper.writeValue(zipOutStream, product);
				
				zipOutStream.closeEntry();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
