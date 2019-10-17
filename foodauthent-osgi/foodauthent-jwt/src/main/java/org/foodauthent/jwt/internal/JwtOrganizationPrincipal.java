package org.foodauthent.jwt.internal;

import org.foodauthent.auth.AbstractOrganizationPrincipal;

public class JwtOrganizationPrincipal extends AbstractOrganizationPrincipal {

	JwtOrganizationPrincipal(final String dn, final String name) {
		super(dn, name);
	}
	
}
