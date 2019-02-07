package org.foodauthent.fakx;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;

import com.fasterxml.jackson.core.type.TypeReference;
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
	public List<Fingerprint> importFingerprints(File file) {
		return importComponents("fingerprints/", file);
	}

	@Override
	public List<Product> importProducts(File file) {
		return importComponents("products/", file);
	}

	@Override
	public List<SOP> importSop(File file) {
		return importComponents("sops/", file);
	}

	private <T> List<T> importComponents(String subfolder, File file) {

		List<T> components = new ArrayList<>();

		ZipFile zipFile;
		try {
			zipFile = new ZipFile(file);
			Enumeration<? extends ZipEntry> entries = zipFile.entries();

			ObjectMapper mapper = new ObjectMapper();

			// Required to deserialize to generic
			TypeReference<T> typeRef = new TypeReference<T>() {
			};

			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();

				if (entry.getName().startsWith(subfolder)) {
					try (InputStream stream = zipFile.getInputStream(entry)) {
						T component = mapper.readValue(stream, typeRef);
						components.add(component);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return components;
	}
}
