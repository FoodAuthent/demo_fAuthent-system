/*******************************************************************************
 * Copyright (c) 2012,2015 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Holger Staudacher - initial API and implementation
 *    ProSyst Software GmbH. - compatibility with OSGi specification 4.2 APIs
 *    Ivan Iliev - added ServletConfigurationTracker
 ******************************************************************************/
package com.eclipsesource.jaxrs.publisher.internal;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.Phaser;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.Path;

import org.glassfish.hk2.osgiresourcelocator.ServiceLoader;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ManagedService;
import org.osgi.util.tracker.BundleTracker;
import org.osgi.util.tracker.BundleTrackerCustomizer;

import com.eclipsesource.jaxrs.publisher.JerseyReadyTracker;
import com.eclipsesource.jaxrs.publisher.ResourceFilter;

public class Activator implements BundleActivator {

	private static final int stateMask = Bundle.INSTALLED | Bundle.RESOLVED | Bundle.STARTING | Bundle.ACTIVE
			| Bundle.STOPPING;

	private BundleTracker<Bundle> tracker;
	private BundleContext context;
	private ServiceRegistration<JerseyReadyTracker> registration;
	private ServiceRegistration connectorRegistration;
	private JAXRSConnector jaxRsConnector;
	private HttpTracker httpTracker;
	private ResourceTracker allTracker;
	private ServletConfigurationTracker servletConfigurationTracker;
	private ApplicationConfigurationTracker applicationConfigurationTracker;
	private ServiceRegistration configRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		this.context = context;
		System.setProperty("javax.ws.rs.ext.RuntimeDelegate",
				"org.glassfish.jersey.server.internal.RuntimeDelegateImpl");
		Set<Bundle> bundles = Stream.concat(jerseyBundles(), hk2Bundles()).filter(b -> b.getState() != Bundle.ACTIVE)
				.collect(Collectors.toSet());
		if (bundles.isEmpty()) {
			register();
		} else {
			this.tracker = new BundleTracker<>(context, stateMask, new BundleWaiter(bundles));
			tracker.open();
			bundles.forEach(b -> {
				if (b.getState() == Bundle.RESOLVED) {
					try {
						b.start();
					} catch (BundleException e) {
						e.printStackTrace();
					}
				}
			});
		}

	}

	private void registerConfiguration(BundleContext context) {
		Dictionary<String, String> properties = new Hashtable<String, String>();
		properties.put(Constants.SERVICE_PID, Configuration.CONFIG_SERVICE_PID);
		configRegistration = context.registerService(ManagedService.class.getName(), new Configuration(jaxRsConnector),
				properties);
	}

	private void register() throws InvalidSyntaxException {
		registration = context.registerService(JerseyReadyTracker.class, new JerseyReadyTrackerImpl(), null);
		jaxRsConnector = new JAXRSConnector(context);
		registerConfiguration(context);
		connectorRegistration = context.registerService(JAXRSConnector.class.getName(), jaxRsConnector, null);
		openHttpServiceTracker(context);
		openServletConfigurationTracker(context);
		openApplicationConfigurationTracker(context);
		openAllServiceTracker(context);
	}

	Stream<Bundle> jerseyBundles() {
		return Arrays.stream(context.getBundles()).filter(b -> b.getSymbolicName().startsWith("org.glassfish.jersey")
				&& b.getState() != Bundle.INSTALLED && b.getState() != Bundle.UNINSTALLED);
	}

	Stream<Bundle> hk2Bundles() {
		return Stream.of(FrameworkUtil.getBundle(ServiceLoader.class));
	}

	private void openHttpServiceTracker(BundleContext context) {
		httpTracker = new HttpTracker(context, jaxRsConnector);
		httpTracker.open();
	}

	private void openServletConfigurationTracker(BundleContext context) {
		servletConfigurationTracker = new ServletConfigurationTracker(context, jaxRsConnector);
		servletConfigurationTracker.open();
	}

	private void openApplicationConfigurationTracker(BundleContext context) {
		applicationConfigurationTracker = new ApplicationConfigurationTracker(context, jaxRsConnector);
		applicationConfigurationTracker.open();
	}

	private void openAllServiceTracker(BundleContext context) throws InvalidSyntaxException {
		ResourceFilter allResourceFilter = getResourceFilter(context);
		allTracker = new ResourceTracker(context, allResourceFilter.getFilter(), jaxRsConnector);
		allTracker.open();
	}

	private ResourceFilter getResourceFilter(BundleContext context) {
		ServiceReference filterReference = context.getServiceReference(ResourceFilter.class.getName());
		if (filterReference != null) {
			return (ResourceFilter) context.getService(filterReference);
		}
		return new AllResourceFilter(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		if (tracker != null) {
			tracker.close();
		}
		if (registration != null) {
			registration.unregister();
			registration = null;
		}
		if (httpTracker != null) {
			httpTracker.close();
		}
		if (servletConfigurationTracker != null) {
			servletConfigurationTracker.close();
		}
		if (applicationConfigurationTracker != null) {
			applicationConfigurationTracker.close();
		}
		if (allTracker != null) {
			allTracker.close();
		}
		if (connectorRegistration != null) {
			connectorRegistration.unregister();
		}
		if (configRegistration != null) {
			configRegistration.unregister();
		}
	}

	private synchronized void start() throws InvalidSyntaxException {
		if (tracker != null) {
			tracker.close();
			register();
			tracker = null;
		}
	}

	// For testing purpose
	Bundle getJerseyAPIBundle() {
		return FrameworkUtil.getBundle(Path.class);
	}

	private class BundleWaiter implements BundleTrackerCustomizer<Bundle> {
		private final Set<Bundle> targets;
		private final Phaser phaser;

		private BundleWaiter(Set<Bundle> targets) {
			this.targets = targets;
			phaser = new Phaser(targets.size()) {
				@Override
				protected boolean onAdvance(int phase, int registeredParties) {
					try {
						start();
					} catch (InvalidSyntaxException e) {
						e.printStackTrace();
					}
					return true;
				}
			};
		}

		@Override
		public Bundle addingBundle(Bundle bundle, BundleEvent event) {
			if (!targets.contains(bundle)) {
				return null;
			} else if (bundle.getState() == Bundle.ACTIVE) {
				phaser.arrive();
				return null;
			} else {
				return bundle;
			}
		}

		@Override
		public void modifiedBundle(Bundle bundle, BundleEvent event, Bundle ignore) {
			if (event.getType() == BundleEvent.STARTED) {
				phaser.arrive();
			}
		}

		@Override
		public void removedBundle(Bundle bundle, BundleEvent event, Bundle ignore) {
		}

	}
}
