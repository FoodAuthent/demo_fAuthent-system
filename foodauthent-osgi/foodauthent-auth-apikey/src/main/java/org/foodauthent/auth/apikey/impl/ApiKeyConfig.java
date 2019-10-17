package org.foodauthent.auth.apikey.impl;

import java.util.ArrayList;
import java.util.List;

public class ApiKeyConfig {
	
    private List<String> securitySchemes = new ArrayList<String>();
    
	public List<String> getSecuritySchemes() {
		return securitySchemes;
	}

	public void setSecuritySchemes(List<String> securitySchemes) {
		this.securitySchemes = securitySchemes;
	}
	
	public static final class ApiUser {
		private String user;
		private String keyId;
		private String secretKey;
		
		public ApiUser() {}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getKeyId() {
			return keyId;
		}

		public void setKeyId(String keyId) {
			this.keyId = keyId;
		}

		public String getSecretKey() {
			return secretKey;
		}

		public void setSecretKey(String secretKey) {
			this.secretKey = secretKey;
		}
		
		
	}

}
