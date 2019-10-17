package org.foodauthent.auth.apikey;

import org.foodauthent.auth.WebAuthenticationMethod;

public interface ApiKeyService extends WebAuthenticationMethod {

	public static final String HTTP_HEADER_KEY_ID = "X-API-KEY-ID";
	
	public static final String HTTP_HEADER_SECRET_KEY = "X-API-KEY-SECRET";
	
}
