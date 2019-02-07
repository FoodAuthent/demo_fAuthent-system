package org.foodauthent.fakx;

import java.io.File;
import java.util.List;

import org.foodauthent.model.Product;

public interface ImporterI {
	List<Product> importProducts(File file);
	
	// Include more imports for components: Fingerprint, SOP, etc.
}
