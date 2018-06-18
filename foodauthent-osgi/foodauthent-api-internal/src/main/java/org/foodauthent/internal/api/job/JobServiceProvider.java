package org.foodauthent.internal.api.job;

import org.foodauthent.internal.impl.job.SimpleJobService;

/**
 * A global static venue to retrieve a singleton instance of {@link JobService}.
 * <p>
 * Will be replaced by the OSGi Service Registry.
 * </p>
 *
 * @author Alexander Kerner
 *
 */
public class JobServiceProvider {

    private static class InstanceHolder {
	private static final JobServiceProvider instance = new JobServiceProvider();
    }

    public static JobServiceProvider getInstance() {
	return InstanceHolder.instance;
    }

    private final JobService jobService;

    private JobServiceProvider() {
	this.jobService = new SimpleJobService();
    }

    public JobService getService() {
	return jobService;
    }

}
