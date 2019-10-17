package org.foodauthent.auth;

public abstract class AbstractOrganizationPrincipal implements OrganizationPrincipal {

	protected String name;

	private String dn;

	protected AbstractOrganizationPrincipal(final String identifier, final String name) {
		this.dn = identifier;
		this.name = name;
	}

	@Override
	public String getDn() {
		return dn;
	}

	@Override
	public String getName() {
		return name;
	}

}
