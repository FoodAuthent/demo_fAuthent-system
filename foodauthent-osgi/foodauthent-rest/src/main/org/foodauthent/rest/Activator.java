package org.foodauthent.rest;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.foodauthent.rest.service.ServiceUtil;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

import com.eclipsesource.jaxrs.publisher.ApplicationConfiguration;

public class Activator implements BundleActivator {

	private final List<ServiceRegistration<?>> registrations = new ArrayList<>();

	@Override
	public void start(BundleContext context) throws Exception {
		configureJaxRSBridge(context);
		registrations.add(context.registerService(ApplicationConfiguration.class, new RestApplicationConfiguration(), null));
		for (Class<?> cls : RestApplicationConfiguration.getProviderClasses()) {
			registrations.add(context.registerService(cls.getName(), cls.newInstance(), null));
		}
		for (Class<?> cls : ServiceUtil.getRestServiceClasses()) {
			registrations.add(context.registerService(cls.getName(), cls.newInstance(), null));
		}
	}

	private void configureJaxRSBridge(BundleContext context) throws Exception {
		final ServiceReference<ConfigurationAdmin> reference = context.getServiceReference(ConfigurationAdmin.class);
		final ConfigurationAdmin configAdmin = context.getService(reference);
		final Configuration configuration = configAdmin.getConfiguration("com.eclipsesource.jaxrs.connector", null);
		final Dictionary<String, Object> properties = new Hashtable<>();
		properties.put("root", "/services");
		configuration.update(properties);
		context.ungetService(reference);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		for (ServiceRegistration<?> serviceRegistration : registrations) {
			serviceRegistration.unregister();
		}
	}

}
