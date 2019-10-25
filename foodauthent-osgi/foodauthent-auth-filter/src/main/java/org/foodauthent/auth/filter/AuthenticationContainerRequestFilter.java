package org.foodauthent.auth.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.foodauthent.auth.WebAuthenticationMethod;
import org.foodauthent.auth.security.SecuritySchemeUtil;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.common.exception.UnauthorizedException;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
@Component(service = AuthenticationContainerRequestFilter.class, scope = ServiceScope.PROTOTYPE)
public class AuthenticationContainerRequestFilter implements ContainerRequestFilter {

	private Logger LOG = LoggerFactory.getLogger(AuthenticationContainerRequestFilter.class);
	
	private Set<WebAuthenticationMethod> authMethods = new TreeSet<WebAuthenticationMethod>(
			new Comparator<WebAuthenticationMethod>() {
				@Override
				public int compare(WebAuthenticationMethod o1, WebAuthenticationMethod o2) {
					// reverse: priority order descending
					return Integer.valueOf(o2.getPriority()).compareTo(Integer.valueOf(o1.getPriority()));
				}
			});

	@Context
	ResourceInfo info;
	
	@Deactivate
	public void deactivate() {
		LOG.info("deactivated");
	}
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		final Collection<String> authSchemes = SecuritySchemeUtil.getSecuritySchemeNames(info.getResourceClass(),
				info.getResourceMethod());
		final boolean authRequired = authMethods.stream().filter(m -> m.isAuthRequired(authSchemes)).findAny()
				.isPresent();
		if (authRequired) {
			for (WebAuthenticationMethod m : authMethods) {
				try {
					requestContext.setSecurityContext(m.getSecurityContext(requestContext));
					return;
				} catch (ServiceException e) {
					// do nothing - try next
				}
			}
			requestContext.abortWith(
					Response.status(Response.Status.UNAUTHORIZED).entity("{\"Reason\":\"Unauthorized\"}").build());
		}
	}

	@Reference(cardinality = ReferenceCardinality.AT_LEAST_ONE, policy = ReferencePolicy.DYNAMIC, unbind = "unbindAuthMethod")
	public void bindAuthMethod(WebAuthenticationMethod method) {
		final Iterator<WebAuthenticationMethod> iter = authMethods.iterator();
		while (iter.hasNext()) {
			if (iter.next().getClass().equals(method.getClass())) {
				iter.remove();
			}
		}
		authMethods.add(method);
	}

	public void unbindAuthMethod(WebAuthenticationMethod method) {
		authMethods.remove(method);
	}

	@Activate
	public void activate(final BundleContext context) {
		LOG.info("activated");
	}
}