package org.foodauthent.ldap.internal;

import org.apache.directory.api.ldap.model.password.PasswordUtil;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.common.exception.UnauthorizedException;
import org.foodauthent.ldap.LdapAuthenticationService;
import org.foodauthent.ldap.LdapOperationManager;
import org.foodauthent.ldap.LdapPersonService;
import org.foodauthent.ldap.beans.LdapPerson;
import org.foodauthent.ldap.config.LDAPConfig;
import org.ldaptive.Credential;
import org.ldaptive.LdapEntry;
import org.ldaptive.LdapException;
import org.ldaptive.auth.AuthenticationRequest;
import org.ldaptive.auth.AuthenticationResponse;
import org.ldaptive.auth.Authenticator;
import org.ldaptive.auth.BindAuthenticationHandler;
import org.ldaptive.auth.SearchDnResolver;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = { LdapAuthenticationService.class }, scope = ServiceScope.SINGLETON)
public class LdapAuthenticationServiceImpl implements LdapAuthenticationService {

	private SearchDnResolver dnResolver;

	private BindAuthenticationHandler authHandler;

	private Authenticator auth;

	private LdapPersonService personService;

	private LDAPConfig config;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LdapAuthenticationServiceImpl.class);

	@Reference(service = LdapOperationManager.class, cardinality = ReferenceCardinality.MANDATORY, unbind = "unbindPooledLdapOperationService")
	public void bindPooledLdapOperationService(final LdapOperationManager ldapService) {
		this.dnResolver = new SearchDnResolver(ldapService.getConnectionFactory());
		dnResolver.setUserFilter("(uid={user})");
		dnResolver.setSubtreeSearch(true);
		if (config != null) {
			dnResolver.setBaseDn(config.getBaseDn());
		}
		authHandler = new BindAuthenticationHandler(ldapService.getConnectionFactory());
		auth = new Authenticator(dnResolver, authHandler);
	}

	public void unbindPooledLdapOperationService(final LdapOperationManager ldapService) {
		this.dnResolver = null;
		this.authHandler = null;
		this.auth = null;
	}

	@Reference(service = LdapPersonService.class, cardinality = ReferenceCardinality.MANDATORY, unbind = "unbindLdapPersonService")
	public void bindLdapPersonService(final LdapPersonService personService) {
		this.personService = personService;
	}

	public void unbindLdapPersonService(final LdapPersonService personService) {
		this.personService = null;
	}

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	public void bindLDAPConfig(final LDAPConfig config) {
		this.config = config;
		if (dnResolver != null) {
			dnResolver.setBaseDn(config.getBaseDn());
		}
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return user's LDAP dn
	 * @throws UnauthorizedException
	 *             authorization failure
	 * @throws ServiceException
	 *             some LDAP error occured
	 */
	public String authenticate(String userName, String password) throws UnauthorizedException, ServiceException {
		return authInternal(userName, password, "cn", "dn", "userPassword").getDn();
	}

	public LdapPerson authenticatePerson(String userName, String password)
			throws UnauthorizedException, ServiceException {
		return personService.map(authInternal(userName, password, personService.getReturnAttributes()));
	}

	private LdapEntry authInternal(String userName, String password, String... attributes)
			throws UnauthorizedException, ServiceException {
		try {
			final AuthenticationResponse response = auth
					.authenticate(new AuthenticationRequest(userName, new Credential(password), attributes));
			if (response.getResult()) { // authentication not really succeeded, just the user was found
				final LdapEntry entry = response.getLdapEntry();
				final byte[] userPassword = entry.getAttribute("userPassword").getBinaryValue();
				if (PasswordUtil.compareCredentials(password.getBytes(), userPassword)) {
					LOGGER.debug("Authentication succeeded for user {}", userName);
					return entry;
				}
				LOGGER.info("Authentication failure for user {}", userName);
			} else {
				LOGGER.info("Authentication failure for unknown user {}", userName);
			}
			throw new UnauthorizedException("authorization failure");
		} catch (LdapException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
