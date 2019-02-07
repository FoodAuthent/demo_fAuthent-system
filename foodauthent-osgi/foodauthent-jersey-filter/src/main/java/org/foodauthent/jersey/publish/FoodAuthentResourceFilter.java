package org.foodauthent.jersey.publish;

import static com.eclipsesource.jaxrs.publisher.ServiceProperties.PUBLISH;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;

import com.eclipsesource.jaxrs.publisher.ResourceFilter;

public class FoodAuthentResourceFilter implements ResourceFilter {

	static final String FTRACE_SERVICE_FILTER = "(&(|(objectClass=org.foodauthent.*)(objectClass=org.glassfish.jersey.*))(!(" + PUBLISH + "=false)))";

	private final BundleContext context;

	public FoodAuthentResourceFilter(BundleContext context) {
		validateContext(context);
		this.context = context;
	}

	private void validateContext(BundleContext context) {
		if (context == null) {
			throw new IllegalArgumentException("context must not be null");
		}
	}

	@Override
	public Filter getFilter() {
		try {
			return context.createFilter(FTRACE_SERVICE_FILTER);
		} catch (InvalidSyntaxException willNotHappen) {
			throw new IllegalStateException(willNotHappen);
		}
	}

}
