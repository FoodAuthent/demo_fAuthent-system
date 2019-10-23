package org.foodauthent.jersey.publish;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.eclipsesource.jaxrs.publisher.ResourceFilter;

public class Activator implements BundleActivator {

	private static BundleContext context;

	private ServiceRegistration<ResourceFilter> reportingResourceFilterServiceRegistration;

	private ServiceRegistration<GZIPWriterInterceptor> gzipWriterInterceptorServiceRegistration;

	private List<ServiceRegistration<? extends ExceptionMapper<?>>> exceptionMapperRegistrations = new ArrayList<>();

	private ServiceRegistration<CorsFilter> corsFilterServiceRegistration;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		reportingResourceFilterServiceRegistration = context.registerService(ResourceFilter.class,
				new FoodAuthentResourceFilter(bundleContext), null);
		gzipWriterInterceptorServiceRegistration = context.registerService(GZIPWriterInterceptor.class,
				new GZIPWriterInterceptor(), null);
		corsFilterServiceRegistration = context.registerService(CorsFilter.class, new CorsFilter(), null);
		exceptionMapperRegistrations.add(context.registerService(JsonMappingExceptionMapper.class,
				new JsonMappingExceptionMapper(), null));
		exceptionMapperRegistrations.add(context.registerService(JsonParseExceptionMapper.class,
				new JsonParseExceptionMapper(), null));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		if (reportingResourceFilterServiceRegistration != null) {
			reportingResourceFilterServiceRegistration.unregister();
			reportingResourceFilterServiceRegistration = null;
		}
		if (gzipWriterInterceptorServiceRegistration != null) {
			gzipWriterInterceptorServiceRegistration.unregister();
			gzipWriterInterceptorServiceRegistration = null;
		}
		if (corsFilterServiceRegistration != null) {
			corsFilterServiceRegistration.unregister();
			corsFilterServiceRegistration = null;
		}
		for (ServiceRegistration<? extends ExceptionMapper<?>> reg : exceptionMapperRegistrations) {
			reg.unregister();
		}
		exceptionMapperRegistrations.clear();
		Activator.context = null;
	}

}
