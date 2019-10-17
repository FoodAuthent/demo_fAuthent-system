package org.foodauthent.auth;

import java.security.Principal;
import java.util.Collection;

public interface UserPrincipal extends Principal {

	public String getDn();
	
	public OrganizationPrincipal getOrganization();
	
	public Collection<UserGroup> getGroups();
	
}