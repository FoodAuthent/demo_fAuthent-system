package org.foodauthent.logging.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingActivator implements BundleActivator {

	private static BundleContext context;

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingActivator.class);

	static BundleContext getContext() {
		return context;
	}

	public LoggingActivator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		LogbackConfigurator.configure();
		LOGGER.info(bundleContext.getBundle().getSymbolicName() + " configured logging implementations");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		LoggingActivator.context = null;
	}

}
