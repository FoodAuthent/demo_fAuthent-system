package org.foodauthent.api;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class ServiceRegistry {

	public static <T> T get(Class<T> clazz) {
		Bundle bundle = FrameworkUtil.getBundle(ServiceRegistry.class);
		if (bundle != null) {
			ServiceTracker<T, T> st = new ServiceTracker<T, T>(bundle.getBundleContext(), clazz, null);
			st.open();
			if (st != null) {
				try {
					// give the runtime some time to startup
					final T s = st.waitForService(60000);
					return s;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
