package org.foodauthent.auth;

public abstract class AbstractUserGroup implements UserGroup {

	protected String name;

	protected AbstractUserGroup(final String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

}
