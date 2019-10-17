package org.foodauthent.auth;

import java.security.Principal;

public interface OrganizationPrincipal extends Principal {

	public String getDn();
	
}
