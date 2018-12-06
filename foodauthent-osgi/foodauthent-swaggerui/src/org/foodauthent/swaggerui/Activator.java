package org.foodauthent.swaggerui;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {

	private ServiceTracker<HttpService, HttpService> httpServiceTracker;

	private HttpServiceTrackerCustomizer customizer;

	private static final Logger LOG = LoggerFactory.getLogger(Activator.class);

	@Override
	public void start(BundleContext context) throws Exception {
		customizer = new HttpServiceTrackerCustomizer(context);
		httpServiceTracker = new ServiceTracker<HttpService, HttpService>(context, HttpService.class, customizer);
		httpServiceTracker.open();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		httpServiceTracker.close();
		customizer.destroy();
		httpServiceTracker = null;
		customizer = null;
	}

	private static final class HttpServiceTrackerCustomizer
			implements ServiceTrackerCustomizer<HttpService, HttpService> {

		private BundleContext context;

		private List<HttpService> httpServices = new ArrayList<HttpService>();

		private HttpServiceTrackerCustomizer(final BundleContext context) {
			this.context = context;
		}

		@Override
		public HttpService addingService(ServiceReference<HttpService> ref) {
			final HttpService httpService = context.getService(ref);
			try {
				httpService.registerServlet("/swaggerui/*", new ResourceServlet(), null,
						httpService.createDefaultHttpContext());
				httpServices.add(httpService);
			} catch (Exception e) {
				LOG.error("unable to register /swaggerui context", e);
			}
			return httpService;
		}

		@Override
		public void modifiedService(ServiceReference<HttpService> ref, HttpService httpService) {
		}

		@Override
		public void removedService(ServiceReference<HttpService> ref, HttpService httpService) {
			unregisterContext(httpService);
			httpServices.remove(httpService);
		}

		public void destroy() {
			for (HttpService s : httpServices) {
				unregisterContext(s);
			}
			httpServices.clear();
			httpServices = null;
			context = null;
		}

		private void unregisterContext(final HttpService httpService) {
			try {
				httpService.unregister("/swaggerui/*");
			} catch (Exception e) {
				LOG.info("unable to unregister /swaggerui context", e);
			}
		}

	}
}
