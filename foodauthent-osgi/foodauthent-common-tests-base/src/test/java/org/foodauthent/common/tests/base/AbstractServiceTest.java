package org.foodauthent.common.tests.base;

import org.foodauthent.config.ConfigurationService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public abstract class AbstractServiceTest {

	private static boolean CONFIG_LOADED = false;

	protected static <T> T getService(Class<T> clazz) {
		final Bundle bundle = FrameworkUtil.getBundle(AbstractServiceTest.class);
		if (bundle != null) {
			final BundleContext bundleContext = bundle.getBundleContext();

			if (!CONFIG_LOADED) {
				final ServiceReference<ConfigurationService> ref = bundle.getBundleContext()
						.getServiceReference(ConfigurationService.class);
				if (ref != null) {
					final ConfigurationService configurationService = bundle.getBundleContext().getService(ref);
					configurationService
							.reload(AbstractServiceTest.class.getResourceAsStream("/META-INF/config/test.conf"));
					CONFIG_LOADED = true;
				}
			}

			ServiceTracker<T, T> st = new ServiceTracker<T, T>(bundleContext, clazz, null);
			st.open();
			if (st != null) {
				try {
					// give the runtime some time to startup
					return st.waitForService(15000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
