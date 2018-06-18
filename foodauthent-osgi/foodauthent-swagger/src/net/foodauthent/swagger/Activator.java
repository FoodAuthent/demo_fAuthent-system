package net.foodauthent.swagger;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

import net.foodauthent.swagger.example.MetaInfo;
import net.foodauthent.swagger.example.MetaInfoService;
import net.foodauthent.swagger.example.UserService;

public class Activator implements BundleActivator {

	private final List<ServiceRegistration<?>> registrations = new ArrayList<>();

	@Override
	public void start(BundleContext context) throws Exception {
		configureSwagger(context);
		registrations.add(context.registerService(UserService.class.getName(), new UserService(), null));
		registrations.add(context.registerService(MetaInfo.class.getName(), new MetaInfoService(), null));
	}

	private void configureSwagger(BundleContext context) throws Exception {
	    final ServiceReference<ConfigurationAdmin> reference = context.getServiceReference( ConfigurationAdmin.class );
	    final ConfigurationAdmin configAdmin = context.getService( reference );
	    final Configuration configuration = configAdmin.getConfiguration( "com.eclipsesource.jaxrs.swagger.config", null );
	    
		final Dictionary<String, Object> properties = new Hashtable<>();

		properties.put("swagger.basePath", "/services");
		properties.put("swagger.info.title", "A Swagger test API");
		properties.put("swagger.info.description", "This API only exist to test swagger support");
		properties.put("swagger.info.version", "1.0");
		properties.put("swagger.info.termsOfService", "Free to enjoy");
		properties.put("swagger.info.contact.name", "Holger Staudacher");
		properties.put("swagger.info.contact.url", "https://github.com/hstaudacher/osgi-jax-rs-connector");
		properties.put("swagger.info.contact.email", "holger.staudacher@gmail.com");
		properties.put("swagger.info.license.name", "Eclipse Public License, version 1.0");
		properties.put("swagger.info.license.url", "http://www.eclipse.org/legal/epl-v10.html");
		properties.put("jersey.config.server.resource.validation.ignoreErrors", true);
	    configuration.update( properties );
	    context.ungetService( reference );
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		for (ServiceRegistration<?> serviceRegistration : registrations) {
			serviceRegistration.unregister();
		}
	}
}
