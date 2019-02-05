package org.foodauthent.jwt.internal;

import org.foodauthent.auth.AbstractUser;

class JwtUser extends AbstractUser {

	JwtUser(final String userIdentifier, final String userName, final String organizationIdentifier,
			final String organizationName, final String[] groups) {
		super(userIdentifier, userName, new JwtUserOrganization(organizationIdentifier, organizationName),
				JwtUserGroup.fromArray(groups));
	}

}
