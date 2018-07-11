package org.foodauthent.api.knime;

import org.foodauthent.internal.api.job.JobService;
import org.foodauthent.internal.impl.job.knime.LocalKnimeJobService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

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
		JobService service = new LocalKnimeJobService();
		context.registerService(JobService.class.getName(), service, null);

		// JobService service = new LocalKnimeJobService();
		// context.registerService(JobService.class.getName(), service, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
