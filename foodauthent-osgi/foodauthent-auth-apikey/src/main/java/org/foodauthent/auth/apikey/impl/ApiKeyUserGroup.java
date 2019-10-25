package org.foodauthent.auth.apikey.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.foodauthent.auth.AbstractUserGroup;
import org.foodauthent.auth.UserGroup;

public class ApiKeyUserGroup extends AbstractUserGroup {

	static final Collection<UserGroup> fromArray(String[] groups) {
		return Arrays.asList(groups).stream().map(g -> new ApiKeyUserGroup(g)).collect(Collectors.toSet());
	}

	ApiKeyUserGroup(final String name) {
		super(name);
	}

}
