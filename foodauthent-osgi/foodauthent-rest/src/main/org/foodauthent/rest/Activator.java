package org.foodauthent.rest;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

import org.foodauthent.rest.json.CollectionJSONWriter;
import org.foodauthent.rest.json.FaModelJSONReader;
import org.foodauthent.rest.json.FaModelJSONWriter;
import org.foodauthent.rest.service.ServiceUtil;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

public class Activator implements BundleActivator {

	private final List<ServiceRegistration<?>> registrations = new ArrayList<>();

	@Override
	public void start(BundleContext context) throws Exception {
		configureSwagger(context);
		for (Class<?> cls : ServiceUtil.getRestServiceClasses()) {
			registrations.add(context.registerService(cls.getName(), cls.newInstance(), null));
		}
	}

	private void configureSwagger(BundleContext context) throws Exception {
		final ServiceReference<ConfigurationAdmin> reference = context.getServiceReference(ConfigurationAdmin.class);
		final ConfigurationAdmin configAdmin = context.getService(reference);
		final Configuration configuration = configAdmin.getConfiguration("com.eclipsesource.jaxrs.swagger.config",
				null);

		final Dictionary<String, Object> properties = new Hashtable<>();

		properties.put("swagger.basePath", "/services");
		properties.put("swagger.info.title", "FoodAuthent v0");
		properties.put("swagger.info.description", "FoodAuthent RESTful Services API");
		properties.put("swagger.info.version", "0.1");
		properties.put("swagger.info.termsOfService", "see FoodAuthent terms and conditions");
		properties.put("swagger.info.contact.name", "api@foodauthent.net");
		properties.put("swagger.info.contact.url", "https://www.foodauthent.de");
		properties.put("swagger.info.contact.email", "api@foodauthent.net");
		properties.put("swagger.info.license.name", "Eclipse Public License, version 1.0");
		properties.put("swagger.info.license.url", "http://www.eclipse.org/legal/epl-v10.html");
		properties.put("jersey.config.server.resource.validation.ignoreErrors", true);
		properties.put("jersey.config.server.provider.classnames", getProviderClassNames());
		properties.put("jersey.config.workers.legacyOrdering", "true");

		configuration.update(properties);
		context.ungetService(reference);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		for (ServiceRegistration<?> serviceRegistration : registrations) {
			serviceRegistration.unregister();
		}
	}

	private static String getProviderClassNames() {
		List<Class<?>> providers = new ArrayList<Class<?>>();
		providers.add(FaModelJSONReader.class);
		providers.add(FaModelJSONWriter.class);
		providers.add(CollectionJSONWriter.class);
		return providers.stream().map(c -> c.getCanonicalName()).collect(Collectors.joining(","));
	}

}
