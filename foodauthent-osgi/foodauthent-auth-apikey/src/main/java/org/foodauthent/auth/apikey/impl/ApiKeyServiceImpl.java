package org.foodauthent.auth.apikey.impl;

import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.foodauthent.auth.SecurityContextImpl;
import org.foodauthent.auth.User;
import org.foodauthent.auth.UserPrincipal;
import org.foodauthent.auth.WebAuthenticationMethod;
import org.foodauthent.auth.apikey.ApiKeyService;
import org.foodauthent.auth.apikey.impl.ApiKeyConfig.ApiUser;
import org.foodauthent.auth.service.AuthenticationService;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.common.exception.UnauthorizedException;
import org.foodauthent.config.ConfigObjectRegistration;
import org.foodauthent.config.ConfigurationListener;
import org.foodauthent.config.ConfigurationService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = { ApiKeyService.class,
		WebAuthenticationMethod.class }, scope = ServiceScope.SINGLETON, immediate = true)
public class ApiKeyServiceImpl implements ApiKeyService {

	private ServiceRegistration<ConfigurationListener> apiKeyConfigServiceRegistration;

	private ApiKeyConfig apiKeyConfig;

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private AuthenticationService authenticationService;

	private Logger LOG = LoggerFactory.getLogger(ApiKeyServiceImpl.class);

	@Override
	public SecurityContext getSecurityContext(ContainerRequestContext requestContext) throws ServiceException {
		final Optional<ApiKeyHeader> header = ApiKeyHeader.of(requestContext);
		if (header.isPresent()) {
			final Optional<UserPrincipal> user = getUserPrincipal(header.get());
			if (user.isPresent()) {
				return new SecurityContextImpl(user.get());
			}

		}
		throw new UnauthorizedException("No ApiKey Authentication Header found");
	}

	@Override
	public Principal getUserPrincipal(HttpServletRequest request) throws ServiceException {
		final Optional<ApiKeyHeader> header = ApiKeyHeader.of(request);
		if (header.isPresent()) {
			final Optional<UserPrincipal> user = getUserPrincipal(header.get());
			if (user.isPresent()) {
				return user.get();
			}
		}
		throw new UnauthorizedException("No ApiKey Authentication Header found");
	}

	@Override
	public boolean isAuthRequired(Collection<String> securitySchemeNames) {
		return apiKeyConfig.getSecuritySchemes().stream() //
				.filter(s -> securitySchemeNames.contains(s)).findAny() //
				.isPresent();
	}

	@Override
	public boolean isAuthSupported(ContainerRequestContext requestContext) {
		return ApiKeyHeader.isAuthSupported(requestContext);
	}

	@Activate
	public void activate(BundleContext bundleContext) {
		if (apiKeyConfigServiceRegistration == null) {
			apiKeyConfigServiceRegistration = ConfigObjectRegistration
					.register(bundleContext, new Consumer<ConfigurationService>() {

						@Override
						public void accept(ConfigurationService configurationService) {
							apiKeyConfig = configurationService.get(ApiKeyConfig.class, "auth.apikey").orElse(null);
						}
					}).get();
		}
	}

	private Optional<UserPrincipal> getUserPrincipal(ApiKeyHeader header)
			throws UnauthorizedException, ServiceException {
		final Optional<ApiUser> user = apiKeyConfig.getUser(header.keyId);
		if (!user.isPresent()) {
			return Optional.empty();
		}
		if (!header.secretKey.equals(user.get().getSecretKey())) {
			return Optional.empty();
		}
		final User authUser = authenticationService.find(user.get().getName());
		final UserPrincipal u = new ApiKeyUserPrincipal(authUser);
		return Optional.ofNullable(u);
	}

	private static final class ApiKeyHeader {

		private String keyId;

		private String secretKey;

		private static boolean isAuthSupported(ContainerRequestContext requestContext) {
			return (requestContext.getHeaderString(HTTP_HEADER_KEY_ID) != null
					&& requestContext.getHeaderString(HTTP_HEADER_SECRET_KEY) != null);
		}

		private static boolean isAuthSupported(HttpServletRequest request) {
			return (request.getHeader(HTTP_HEADER_KEY_ID) != null && request.getHeader(HTTP_HEADER_SECRET_KEY) != null);
		}

		private static Optional<ApiKeyHeader> of(ContainerRequestContext requestContext) {
			if (isAuthSupported(requestContext)) {
				return Optional.of(new ApiKeyHeader(requestContext));
			}
			return Optional.empty();
		}

		private static Optional<ApiKeyHeader> of(HttpServletRequest request) {
			if (isAuthSupported(request)) {
				return Optional.of(new ApiKeyHeader(request));
			}
			return Optional.empty();
		}

		private ApiKeyHeader(ContainerRequestContext requestContext) {
			this.keyId = requestContext.getHeaderString(HTTP_HEADER_KEY_ID);
			this.secretKey = hashSecretKey(requestContext.getHeaderString(HTTP_HEADER_SECRET_KEY));
		}

		private ApiKeyHeader(HttpServletRequest request) {
			this.keyId = request.getHeader(HTTP_HEADER_KEY_ID);
			this.secretKey = hashSecretKey(request.getHeader(HTTP_HEADER_SECRET_KEY));
		}

		private String hashSecretKey(final String secretKey) {
			return "sha256;" + DigestUtils.sha256Hex(secretKey);
		}
	}

	@Override
	public int getPriority() {
		return 0;
	}

}
