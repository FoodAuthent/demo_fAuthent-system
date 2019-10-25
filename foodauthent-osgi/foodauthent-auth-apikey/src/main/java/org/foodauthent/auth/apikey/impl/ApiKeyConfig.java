package org.foodauthent.auth.apikey.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ApiKeyConfig {
	
    private List<String> securitySchemes = new ArrayList<String>();
    
    private List<ApiUser> users = new ArrayList<ApiUser>();
    
	public List<ApiUser> getUsers() {
		return users;
	}

	public void setUsers(List<ApiUser> users) {
		this.users = users;
	}

	public List<String> getSecuritySchemes() {
		return securitySchemes;
	}

	public void setSecuritySchemes(List<String> securitySchemes) {
		this.securitySchemes = securitySchemes;
	}
	
	public static final class ApiUser {
		private String name;
		private String keyId;
		private String secretKey;
		
		public ApiUser() {}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

  public Optional<ApiUser> getUser(String key) {
	  return users.stream().filter(u -> u.keyId.equals(key)).findFirst();
  }
	
}
