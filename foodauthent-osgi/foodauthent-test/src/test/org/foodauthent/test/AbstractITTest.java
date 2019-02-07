package org.foodauthent.test;

import javax.ws.rs.client.WebTarget;

import org.junit.BeforeClass;
import org.osgi.framework.BundleException;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public abstract class AbstractITTest {

    @BeforeClass
    public static void setup() throws BundleException {
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
    }

    @Deprecated
    protected final WebTarget webTarget() {
	return TestUtils.newWebTarget();
    }
    
    protected final <S> S restService(Class<S> serviceClass) {
	return TestUtils.createClientProxy(serviceClass);
    }

}
