package org.foodauthent.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.client.WebTarget;

import org.glassfish.hk2.osgiresourcelocator.ServiceLoader;
import org.junit.BeforeClass;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public abstract class AbstractITTest {

    @BeforeClass
    public static void setup() throws BundleException {
	Bundle bundle = FrameworkUtil.getBundle(ServiceLoader.class);
	if (bundle.getState() != Bundle.ACTIVE) {
	    bundle.start();
	}
	List<Bundle> jerseyBundles = Arrays.stream(bundle.getBundleContext().getBundles())
		.filter(b -> b.getSymbolicName().startsWith("org.glassfish.jersey") && b.getState() != Bundle.INSTALLED
			&& b.getState() != Bundle.UNINSTALLED && b.getState() != Bundle.ACTIVE)
		.collect(Collectors.toList());
	for (Bundle b : jerseyBundles) {
	    b.start();
	}
    }

    protected final WebTarget webTarget() {
	return TestUtils.newWebTarget();
    }

}
