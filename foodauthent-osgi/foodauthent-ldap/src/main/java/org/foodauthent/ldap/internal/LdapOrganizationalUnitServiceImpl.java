package org.foodauthent.ldap.internal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.EntityNotFoundException;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.ldap.LdapOperationManager;
import org.foodauthent.ldap.LdapOrganizationalUnitService;
import org.foodauthent.ldap.beans.LdapOrganizationalUnit;
import org.foodauthent.ldap.config.LDAPConfig;
import org.ldaptive.LdapException;
import org.ldaptive.SearchScope;
import org.ldaptive.templates.SearchTemplates;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = { LdapOrganizationalUnitService.class }, scope = ServiceScope.SINGLETON)
public class LdapOrganizationalUnitServiceImpl extends AbstractLdapEntryService<LdapOrganizationalUnit>
		implements LdapOrganizationalUnitService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LdapOrganizationalUnitServiceImpl.class);

	private static final String OBJECT_CLASS_FILTER = "(&(objectClass=organizationalUnit))";

	private static final SearchTemplates termTemplate = new SearchTemplates( //
			createFilters(OBJECT_CLASS_FILTER, //
					"(|(ou={term1})(l={term1}))", //
					"(|(ou={term1}*)(l={term1}*))", //
					"(|(ou=*{term1}*)(l=*{term1}*))"));

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private LdapOperationManager ldapOperationManager;

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private LDAPConfig config;

	public LdapOrganizationalUnitServiceImpl() {
		super(LdapOrganizationalUnit.class, termTemplate);
	}

	@Activate
	public void activate() {
		super.initialize(ldapOperationManager, config);
	}

	@Override
	public LdapOrganizationalUnit add(LdapOrganizationalUnit v) throws EntityAlreadyExistsException, ServiceException {
		final LdapOrganizationalUnit org = super.add(v);
		// add default ou for users and groups if this is no dn for users or groups
		if (!org.getDn().startsWith(LdapOrganizationalUnit.OU_USERS)
				&& !org.getDn().startsWith(LdapOrganizationalUnit.OU_GROUPS)) {
			add(new LdapOrganizationalUnit(String.join(",", LdapOrganizationalUnit.OU_USERS, org.getDn())));
			add(new LdapOrganizationalUnit(String.join(",", LdapOrganizationalUnit.OU_GROUPS, org.getDn())));
		}
		return org;
	}

	@Override
	public void delete(LdapOrganizationalUnit v)
			throws EntityNotFoundException, InvalidOperationException, ServiceException {
		// find out if ou has other children than users and groups
		try {
			final Set<String> allowedDns = new HashSet<String>(Arrays.asList( //
					String.join(",", LdapOrganizationalUnit.OU_GROUPS, v.getDn()), //
					String.join(",", LdapOrganizationalUnit.OU_USERS, v.getDn())));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(String.format("collecting children for %s", v.getDn()));
			}
			final Set<String> existingDns = ldapService.search(v.getDn(), "(objectClass=*)", SearchScope.ONELEVEL, "dn")
					.getEntries().stream().map(e -> {
						if (LOGGER.isDebugEnabled()) {
							LOGGER.debug(String.format("found child %s", e.getDn()));
						}
						return e.getDn();
					}).collect(Collectors.toSet());
			if (existingDns.isEmpty()) {
				throw new EntityNotFoundException(String.format("OrganizationalUnit %s not found", v.getDn()));
			}
			if (!allowedDns.equals(existingDns)) {
				throw new InvalidOperationException(String.format("OrganizationalUnit %s has children", v.getDn()));
			}
		} catch (LdapException e) {
			throw new ServiceException(e.getMessage());
		}
		// try to remove default ou for users and groups
		if (!v.getDn().startsWith(LdapOrganizationalUnit.OU_USERS)
				&& !v.getDn().startsWith(LdapOrganizationalUnit.OU_GROUPS)) {
			super.delete(new LdapOrganizationalUnit(String.join(",", LdapOrganizationalUnit.OU_USERS, v.getDn())));
			super.delete(new LdapOrganizationalUnit(String.join(",", LdapOrganizationalUnit.OU_GROUPS, v.getDn())));
		}
		super.delete(v);
	}

}
