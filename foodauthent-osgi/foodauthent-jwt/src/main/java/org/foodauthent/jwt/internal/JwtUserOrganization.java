package org.foodauthent.jwt.internal;

import org.foodauthent.auth.AbstractUserOrganization;

public class JwtUserOrganization extends AbstractUserOrganization {

	JwtUserOrganization(final String identifier, final String name) {
		super(identifier, name);
	}
	
}
