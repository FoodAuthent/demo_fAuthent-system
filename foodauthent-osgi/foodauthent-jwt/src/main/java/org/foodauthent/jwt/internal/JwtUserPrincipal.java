package org.foodauthent.jwt.internal;

import java.util.stream.Collectors;

import org.foodauthent.auth.AbstractUserPrincipal;
import org.foodauthent.auth.User;

class JwtUserPrincipal extends AbstractUserPrincipal {

	JwtUserPrincipal(final String dn, final String userName, final String organizationIdentifier,
			final String organizationName, final String[] groups) {
		super(dn, userName, new JwtOrganizationPrincipal(organizationIdentifier, organizationName),
				JwtUserGroup.fromArray(groups));
	}

	JwtUserPrincipal(final User user) {
		this(user.getIdentifier(), user.getName(), user.getOrganization().getIdentifier(),
				user.getOrganization().getName(),
				user.getGroups().stream().map(g -> g.getName()).collect(Collectors.toList()).toArray(new String[0]));
	}
}
