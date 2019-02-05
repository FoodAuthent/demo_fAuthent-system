package org.foodauthent.auth;

import java.util.Collection;

public abstract class AbstractUser implements User {

	protected Organization organization;

	protected Collection<UserGroup> groups;

	protected String name;

	protected String identifier;

	protected AbstractUser(final String identifier, final String name, final Organization organization,
			final Collection<UserGroup> groups) {
		this.identifier = identifier;
		this.name = name;
		this.organization = organization;
		this.groups = groups;
	}

	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Organization getOrganization() {
		return organization;
	}

	@Override
	public Collection<UserGroup> getGroups() {
		return groups;
	}

}
