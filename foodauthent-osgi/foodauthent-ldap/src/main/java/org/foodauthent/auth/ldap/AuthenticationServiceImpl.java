package org.foodauthent.auth.ldap;

import java.util.List;
import java.util.stream.Collectors;

import org.foodauthent.auth.Organization;
import org.foodauthent.auth.User;
import org.foodauthent.auth.UserGroup;
import org.foodauthent.auth.service.AuthenticationService;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.common.exception.UnauthorizedException;
import org.foodauthent.ldap.DnUtil;
import org.foodauthent.ldap.LdapAuthenticationService;
import org.foodauthent.ldap.LdapGroupService;
import org.foodauthent.ldap.LdapOrganizationalUnitService;
import org.foodauthent.ldap.beans.LdapPerson;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;


@Component(service = AuthenticationService.class, scope = ServiceScope.SINGLETON)
public class AuthenticationServiceImpl implements AuthenticationService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private LdapAuthenticationService ldapAuthenticationService;

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private LdapOrganizationalUnitService LdapOrganizationalUnitService;

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private LdapGroupService ldapGroupService;

	public User authenticate(final String userName, final String password)
			throws UnauthorizedException, ServiceException {
		final LdapPerson person = ldapAuthenticationService.authenticatePerson(userName, password);
		final String organizationalUnitDn = DnUtil.getOrganizationalUnitDn(person);
		final Organization organization = organizationalUnitDn != null
				? new LdapUserOrganization(LdapOrganizationalUnitService.get(organizationalUnitDn))
				: LdapUserOrganization.ROOT;
		final List<UserGroup> groups = ldapGroupService.getUserGroups(person.getDn()).stream()
				.map(g -> new LdapUserGroup(g)).collect(Collectors.toList());
		return new LdapUser(person, organization, groups);
	}

}
