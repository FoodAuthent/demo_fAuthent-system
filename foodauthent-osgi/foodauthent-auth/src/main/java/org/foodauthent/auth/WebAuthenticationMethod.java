package org.foodauthent.auth;

import java.security.Principal;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.SecurityContext;

import org.foodauthent.common.exception.UnauthorizedException;


public interface WebAuthenticationMethod {

	public SecurityContext getSecurityContext(ContainerRequestContext requestContext) throws UnauthorizedException;
	
	public Principal getUserPrincipal(HttpServletRequest request) throws UnauthorizedException;
	
	public boolean isAuthRequired(Collection<String> securitySchemeNames);

	boolean isAuthSupported(ContainerRequestContext requestContext);
	
	public int getPriority();

}
