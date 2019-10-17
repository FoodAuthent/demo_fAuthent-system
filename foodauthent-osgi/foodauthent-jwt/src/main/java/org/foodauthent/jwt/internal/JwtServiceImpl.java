package org.foodauthent.jwt.internal;

import java.security.Principal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.SecurityContext;

import org.foodauthent.auth.SecurityContextImpl;
import org.foodauthent.auth.User;
import org.foodauthent.auth.UserPrincipal;
import org.foodauthent.auth.WebAuthenticationMethod;
import org.foodauthent.auth.service.AuthenticationService;
import org.foodauthent.common.exception.UnauthorizedException;
import org.foodauthent.config.ConfigObjectRegistration;
import org.foodauthent.config.ConfigurationListener;
import org.foodauthent.config.ConfigurationService;
import org.foodauthent.jwt.JwtService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component(service = { JwtService.class, WebAuthenticationMethod.class }, //
		property = { //
				"osgi.command.scope=nos_auth", //
				"osgi.command.function=jwt_create" })

public class JwtServiceImpl implements JwtService {

	private Algorithm algorithm;

	private JWTVerifier verifier;

	private JwtConfig jwtConfig;

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtServiceImpl.class);

	private ServiceRegistration<ConfigurationListener> jwtConfigServiceRegistration;

	@Reference(cardinality = ReferenceCardinality.OPTIONAL)
	private AuthenticationService authenticationService;

	private static final String CLAIM_USER_NAME = "userName";
	private static final String CLAIM_USER_IDENTIFIER = "userIdentifier";
	private static final String CLAIM_ORGANIZATION_NAME = "organizationName";
	private static final String CLAIM_ORGANIZATION_IDENTIFIER = "organizationIdentifier";
	private static final String CLAIM_GROUPS = "groups";

	private static final String BEARER = "Bearer";

	private static final String AUTHORIZATION = "Authorization";
	
	@Override
	public String createToken(UserPrincipal user, final int lifeTimeMinutes) throws UnauthorizedException {
		if (user == null || user.getOrganization() == null) {
			throw new UnauthorizedException("user and organization must not be null");
		}
		try {
			final JWTCreator.Builder builder = JWT.create() //
					.withIssuer(jwtConfig.getIssuer()) //
					.withClaim(CLAIM_USER_NAME, user.getName()) //
					.withClaim(CLAIM_USER_IDENTIFIER, user.getDn()) //
					.withClaim(CLAIM_ORGANIZATION_NAME, user.getOrganization().getName()) //
					.withClaim(CLAIM_ORGANIZATION_IDENTIFIER, user.getOrganization().getDn());
			if (user.getGroups() != null) {
				builder.withArrayClaim(CLAIM_GROUPS, user.getGroups().stream().map(g -> g.getName())
						.collect(Collectors.toList()).toArray(new String[0]));
			} else {
				builder.withArrayClaim(CLAIM_GROUPS, new String[0]);
			}
			final long expiresAtMillis = System.currentTimeMillis()
					+ Duration.ofMinutes(lifeTimeMinutes).toMillis();
			final Date expiresAt = new Date(expiresAtMillis);
			builder.withExpiresAt(expiresAt);
			final String token = builder.sign(algorithm);
			return token;
		} catch (JWTCreationException e) {
			throw new UnauthorizedException("unable to create token", e);
		}
	}

	@Override
	public UserPrincipal verifyToken(String token) throws UnauthorizedException {
		if (token == null) {
			throw new UnauthorizedException("token must not be null");
		}
		try {
			DecodedJWT jwt = verifier.verify(token);
			if (jwt.getExpiresAt().before(new Date())) {
				throw new UnauthorizedException("token expired");
			}
			try {
				final String userName = jwt.getClaim(CLAIM_USER_NAME).asString();
				final String userIdentifier = jwt.getClaim(CLAIM_USER_IDENTIFIER).asString();
				final String organizationName = jwt.getClaim(CLAIM_ORGANIZATION_NAME).asString();
				final String organizationIdentifier = jwt.getClaim(CLAIM_ORGANIZATION_IDENTIFIER).asString();
				final String[] groups = jwt.getClaim(CLAIM_GROUPS).asArray(String.class);
				return new JwtUserPrincipal(userIdentifier, userName, organizationIdentifier, organizationName, groups);
			} catch (Exception e) {
				LOGGER.error("unable to deserialize user information from token", e);
				throw new UnauthorizedException("unable to deserialize user from token", e);
			}
		} catch (JWTVerificationException e) {
			throw new UnauthorizedException("unable to verify token", e);
		}
	}

	@Override
	public String refreshToken(String token) throws UnauthorizedException {
		return createToken(verifyToken(token));
	}

	@Activate
	public void activate(BundleContext bundleContext) {
		if (jwtConfigServiceRegistration == null) {
			jwtConfigServiceRegistration = ConfigObjectRegistration
					.register(bundleContext, new Consumer<ConfigurationService>() {

						@Override
						public void accept(ConfigurationService configurationService) {
							jwtConfig = configurationService.get(JwtConfig.class, "auth.jwt").orElse(null);
							if (jwtConfig != null) {
								algorithm = Algorithm.HMAC256(jwtConfig.getSecrect());
								verifier = JWT.require(algorithm).withIssuer(jwtConfig.getIssuer()).build();
								LOGGER.info("JWT Token Authentication successfully configured");
							} else {
								LOGGER.error("JWT Token Authentication  not configured");
							}
						}
					}).get();
		}
	}

	@Deactivate
	public void deactivate() {
		if (jwtConfigServiceRegistration != null) {
			jwtConfigServiceRegistration.unregister();
			jwtConfigServiceRegistration = null;
			jwtConfig = null;
		}
	}

	@Override
	public SecurityContext getSecurityContext(ContainerRequestContext requestContext) throws UnauthorizedException {
		final Optional<String> authorizationHeader = getHeaderString(requestContext);
		if (authorizationHeader.isPresent()) {
			final UserPrincipal user = verifyToken(authorizationHeader.get().replaceFirst(BEARER + " ", ""));
			if (user != null) {
				return new SecurityContextImpl(user);
			}
		}
		throw new UnauthorizedException("No Bearer Authentication Header found");
	}

	@Override
	public Principal getUserPrincipal(HttpServletRequest request) throws UnauthorizedException {
		final String authorizationHeader = request.getHeader(AUTHORIZATION);
		if (authorizationHeader != null) {
			final UserPrincipal user = verifyToken(authorizationHeader.replaceFirst(BEARER + " ", ""));
			if (user != null) {
				return user;
			}

		}
		throw new UnauthorizedException("No Bearer Authentication Header found");
	}

	@Override
	public boolean isAuthRequired(Collection<String> securitySchemeNames) {
		return jwtConfig.getSecuritySchemes().stream() //
				.filter(s -> securitySchemeNames.contains(s)).findAny() //
				.isPresent();
	}

	@Override
	public boolean isAuthSupported(ContainerRequestContext requestContext) {
		final Optional<String> authorizationHeader = getHeaderString(requestContext);
		return authorizationHeader.isPresent() && authorizationHeader.get().startsWith(BEARER);
	}

	private Optional<String> getHeaderString(final ContainerRequestContext requestContext) {
		return Optional.ofNullable(requestContext.getHeaderString(AUTHORIZATION));
	}
	
	@Override
	public int getPriority() {
		return 10;
	}


	/**
	 * OSGI console command for create long living JWT Tokens
	 */
	public String jwt_create(String uid, String lifeTimeMinutes) {
		if (authenticationService == null) {
			return "no AuthenticationService instance available";
		}
		try {
			final int lifeTime = Integer.parseInt(lifeTimeMinutes);
			final User user = authenticationService.find(uid);
			final String token = createToken(user, lifeTime);
			return token;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	@Override
	public String createToken(User user, int lifeTime) throws UnauthorizedException {
		return createToken(new JwtUserPrincipal(user), lifeTime);
	}

	@Override
	public String createToken(UserPrincipal user) throws UnauthorizedException {
		return createToken(user, jwtConfig.getExpiryMinutes());
	}

	@Override
	public String createToken(User user) throws UnauthorizedException {
		return createToken(new JwtUserPrincipal(user));
	}

}
