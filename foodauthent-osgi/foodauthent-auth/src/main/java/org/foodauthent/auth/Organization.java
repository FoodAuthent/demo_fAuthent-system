package org.foodauthent.auth;

import java.security.Principal;

public interface Organization extends Principal {

	public String getIdentifier();
	
}
