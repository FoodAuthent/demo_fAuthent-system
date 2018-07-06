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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eclipsesource.jaxrs.publisher.ApplicationConfiguration;

public class Activator implements BundleActivator {

    private final List<ServiceRegistration<?>> registrations = new ArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(Activator.class);

    @Override
    public void start(BundleContext context) throws Exception {
	try {
	    configureJaxRSBridge(context);
	    try {
		ServiceReference<ApplicationConfiguration> ref = context
			.getServiceReference(ApplicationConfiguration.class);
		if (ref == null) {
		    registrations.add(context.registerService(ApplicationConfiguration.class,
			    new RestApplicationConfiguration(), null));
		    LOG.debug(String.format("registered configuration class %s",
			    RestApplicationConfiguration.class.getName()));
		} else {
		    LOG.warn(String.format("another configuration class is already registered: %s",
			    context.getService(ref).getClass().getName()));
		}
	    } catch (Throwable e) {
		LOG.error(String.format("unable to register configuration class %s",
			RestApplicationConfiguration.class.getName()));
		throw new Exception(e);
	    }
	    for (Class<?> cls : RestApplicationConfiguration.getProviderClasses()) {
		try {
		    registrations.add(context.registerService(cls.getName(), cls.newInstance(), null));
		    LOG.info(String.format("registered provider class %s", cls.getName()));
		} catch (Throwable e) {
		    LOG.error(String.format("unable to register provider class %s", cls.getName()));
		    throw new Exception(e);
		}
	    }
	    for (Class<?> cls : ServiceUtil.getRestServiceClasses()) {
		try {
		    registrations.add(context.registerService(cls.getName(), cls.newInstance(), null));
		    LOG.info(String.format("registered REST service class %s", cls.getName()));
		} catch (Throwable e) {
		    LOG.error(String.format("unable to register REST service class %s", cls.getName()));
		    throw new Exception(e);
		}
	    }
	} catch (Exception e) {
	    LOG.error("unable to activate foodauthent-rest bundle", e);
	    stop(context);
	    throw e;
	}
    }

    private void configureJaxRSBridge(BundleContext context) throws Exception {
	final ServiceReference<ConfigurationAdmin> reference = context.getServiceReference(ConfigurationAdmin.class);
	final ConfigurationAdmin configAdmin = context.getService(reference);
	final Configuration configuration = configAdmin.getConfiguration("com.eclipsesource.jaxrs.connector", null);
	final Dictionary<String, Object> properties = new Hashtable<>();
	properties.put("root", "/");
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
