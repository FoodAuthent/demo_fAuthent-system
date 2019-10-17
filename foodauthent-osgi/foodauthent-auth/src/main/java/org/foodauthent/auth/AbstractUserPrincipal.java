package org.foodauthent.auth;

import java.util.Collection;

public abstract class AbstractUserPrincipal implements UserPrincipal {

	protected OrganizationPrincipal organization;

	protected Collection<UserGroup> groups;

	protected String name;

	protected String dn;

	protected AbstractUserPrincipal(final String identifier, final String name, final OrganizationPrincipal organization,
			final Collection<UserGroup> groups) {
		this.dn = identifier;
		this.name = name;
		this.organization = organization;
		this.groups = groups;
	}

	@Override
	public String getDn() {
		return dn;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public OrganizationPrincipal getOrganization() {
		return organization;
	}

	@Override
	public Collection<UserGroup> getGroups() {
		return groups;
	}

}
