package org.foodauthent.fakx;

import java.io.File;
import java.util.List;

import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;

public interface ImporterI {
	List<Fingerprint> importFingerprints(File file);
	List<Product> importProducts(File file);
	List<SOP> importSop(File file);
	
	// Include more imports for components
}
