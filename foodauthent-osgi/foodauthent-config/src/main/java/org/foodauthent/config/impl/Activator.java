package org.foodauthent.config.impl;

import org.foodauthent.config.ConfigurationListener;
import org.foodauthent.config.ConfigurationService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {

	private static BundleContext context;

	private ServiceRegistration<ConfigurationService> configurationServiceRegistration;

	private ConfigurationServiceImpl configurationService;

	private ServiceTracker<ConfigurationListener, ConfigurationListener> configurationListenerTracker;

	private static final String[] TYPESAFE_CONFIG_PROPERTIES = new String[] { "config.resource", "config.file",
			"config.url" };

	private static final Logger LOG = LoggerFactory.getLogger(Activator.class);

	static BundleContext getContext() {
		return context;
	}

	public Activator() {
		this.configurationService = new ConfigurationServiceImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		final String configProperty = configProperty();
		if (configProperty != null) {
			LOG.info("loading config from " + configProperty);
			configurationService.reload();
		} else {
			LOG.info("loading default config for local");
			configurationService.reload(Activator.class.getClassLoader(), "/META-INF/local");
		}
		this.configurationServiceRegistration = bundleContext.registerService(ConfigurationService.class,
				this.configurationService, null);

		configurationListenerTracker = new ServiceTracker<>(bundleContext, ConfigurationListener.class,
				configListenerTrackerCustomizer(bundleContext));
		configurationListenerTracker.open();

	}

	private String configProperty() {
		for (String p : Activator.TYPESAFE_CONFIG_PROPERTIES) {
			if (System.getProperty(p) != null) {
				return p + "=" + System.getProperty(p);
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		configurationServiceRegistration.unregister();
		configurationServiceRegistration = null;
		Activator.context = null;
	}

	private ServiceTrackerCustomizer<ConfigurationListener, ConfigurationListener> configListenerTrackerCustomizer(
			final BundleContext context) {
		return new ServiceTrackerCustomizer<ConfigurationListener, ConfigurationListener>() {

			@Override
			public ConfigurationListener addingService(ServiceReference<ConfigurationListener> ref) {
				final ConfigurationListener l = context.getService(ref);
				l.loaded(configurationService);
				return l;
			}

			@Override
			public void modifiedService(ServiceReference<ConfigurationListener> ref, ConfigurationListener l) {
			}

			@Override
			public void removedService(ServiceReference<ConfigurationListener> ref, ConfigurationListener l) {
			}

		};
	}
}
