package org.foodauthent.jwt.internal;

import java.time.Duration;
import java.util.Date;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.foodauthent.auth.User;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component(service = JwtService.class)
public class JwtServiceImpl implements JwtService {

	private Algorithm algorithm;

	private JWTVerifier verifier;

	private JwtConfig jwtConfig;

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtServiceImpl.class);

	private ServiceRegistration<ConfigurationListener> jwtConfigServiceRegistration;

	private static final String CLAIM_USER_NAME = "userName";
	private static final String CLAIM_USER_IDENTIFIER = "userIdentifier";
	private static final String CLAIM_ORGANIZATION_NAME = "organizationName";
	private static final String CLAIM_ORGANIZATION_IDENTIFIER = "organizationIdentifier";
	private static final String CLAIM_GROUPS = "groups";

	@Override
	public String create(User user) throws UnauthorizedException {
		if (user == null || user.getOrganization() == null) {
			throw new UnauthorizedException("user and organization must not be null");
		}
		try {
			final JWTCreator.Builder builder = JWT.create() //
					.withIssuer(jwtConfig.getIssuer()) //
					.withClaim(CLAIM_USER_NAME, user.getName()) //
					.withClaim(CLAIM_USER_IDENTIFIER, user.getIdentifier()) //
					.withClaim(CLAIM_ORGANIZATION_NAME, user.getOrganization().getName()) //
					.withClaim(CLAIM_ORGANIZATION_IDENTIFIER, user.getOrganization().getIdentifier());
			if (user.getGroups() != null) {
				builder.withArrayClaim(CLAIM_GROUPS, user.getGroups().stream().map(g -> g.getName())
						.collect(Collectors.toList()).toArray(new String[0]));
			} else {
				builder.withArrayClaim(CLAIM_GROUPS, new String[0]);
			}
			final long expiresAtMillis = System.currentTimeMillis() + Duration.ofMinutes(jwtConfig.getExpiryMinutes()).toMillis();
			final Date expiresAt = new Date(expiresAtMillis); 
			builder.withExpiresAt(expiresAt);
			final String token = builder.sign(algorithm);
			return token;
		} catch (JWTCreationException e) {
			throw new UnauthorizedException("unable to create token", e);
		}
	}

	@Override
	public User verify(String token) throws UnauthorizedException {
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
				return new JwtUser(userIdentifier, userName, organizationIdentifier, organizationName, groups);
			} catch (Exception e) {
				LOGGER.error("unable to deserialize user information from token", e);
				throw new UnauthorizedException("unable to deserialize user from token", e);
			}
		} catch (JWTVerificationException e) {
			throw new UnauthorizedException("unable to verify token", e);
		}
	}

	@Override
	public String refresh(String token) throws UnauthorizedException {
		return create(verify(token));
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

}
