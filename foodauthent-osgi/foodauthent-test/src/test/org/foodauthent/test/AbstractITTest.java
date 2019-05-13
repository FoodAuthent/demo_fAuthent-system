package org.foodauthent.test;

import org.foodauthent.rest.client.FASystemClient;
import org.junit.Before;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public abstract class AbstractITTest {
    
    private FASystemClient faSystemClient;

//    @BeforeClass
//    public static void setup() throws BundleException {
	// Bundle bundle = FrameworkUtil.getBundle(ServiceLoader.class);
	// if (bundle.getState() != Bundle.ACTIVE) {
	// bundle.start();
	// }
	// List<Bundle> jerseyBundles =
	// Arrays.stream(bundle.getBundleContext().getBundles())
	// .filter(b -> b.getSymbolicName().startsWith("org.glassfish.jersey") &&
	// b.getState() != Bundle.INSTALLED
	// && b.getState() != Bundle.UNINSTALLED && b.getState() != Bundle.ACTIVE)
	// .collect(Collectors.toList());
	// for (Bundle b : jerseyBundles) {
	// b.start();
	// }
//    }
    
    @Before
    public void setup() {
	faSystemClient = new FASystemClient("localhost", 9090);
    }
    
    protected FASystemClient client() {
	return faSystemClient;
    }
}
