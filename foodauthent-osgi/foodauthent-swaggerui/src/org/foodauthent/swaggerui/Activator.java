package org.foodauthent.swaggerui;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

public class Activator implements BundleActivator {

    private ResourceServlet servlet = new ResourceServlet();

    @Override
    public void start(BundleContext context) throws Exception {
	ServiceReference<HttpService> ref = context.getServiceReference(HttpService.class);
	if (ref != null) {
	    HttpService httpService = context.getService(ref);
	    httpService.registerServlet("/swaggerui/*", servlet, null, httpService.createDefaultHttpContext());
	}
    }

    @Override
    public void stop(BundleContext context) throws Exception {
	ServiceReference<HttpService> ref = context.getServiceReference(HttpService.class);
	if (ref != null) {
	    HttpService httpService = context.getService(ref);
	    httpService.unregister("/swaggerui/*");
	}
    }

}
