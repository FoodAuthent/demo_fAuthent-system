package org.foodauthent.auth;

import java.security.Principal;
import java.util.Collection;

public interface User extends Principal {

	public String getIdentifier();
	
	public Organization getOrganization();
	
	public Collection<UserGroup> getGroups();
	
}