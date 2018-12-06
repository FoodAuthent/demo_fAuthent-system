package org.foodauthent.config.impl;

import org.foodauthent.config.ConfigurationService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;

	private ServiceRegistration<ConfigurationService> configurationServiceRegistration;

	private ConfigurationServiceImpl configurationService; 
	
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
		this.configurationService.reload();
		this.configurationServiceRegistration = bundleContext.registerService(ConfigurationService.class,
				this.configurationService, null);
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

}
