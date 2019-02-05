package org.foodauthent.auth;

public abstract class AbstractUserOrganization implements Organization {

	protected String name;

	private String identifier;

	protected AbstractUserOrganization(final String identifier, final String name) {
		this.identifier = identifier;
		this.name = name;
	}

	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String getName() {
		return name;
	}

}
