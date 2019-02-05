package org.foodauthent.jwt.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.foodauthent.auth.AbstractUserGroup;
import org.foodauthent.auth.UserGroup;

public class JwtUserGroup extends AbstractUserGroup {

	static final Collection<UserGroup> fromArray(String[] groups) {
		return Arrays.asList(groups).stream().map(g -> new JwtUserGroup(g)).collect(Collectors.toSet());
	}

	JwtUserGroup(final String name) {
		super(name);
	}

}
