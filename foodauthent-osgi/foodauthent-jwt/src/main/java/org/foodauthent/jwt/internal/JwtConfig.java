package org.foodauthent.jwt.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JwtConfig {
	
    private String secrect;
    
    private String audience;
    
    private String issuer;

    private int expiryMinutes = 120;
    
    private List<String> securitySchemes = Arrays.asList("jwtAuth");
    
	public String getSecrect() {
		return secrect;
	}

	public void setSecrect(String secrect) {
		this.secrect = secrect;
	}

	public String getAudience() {
		return audience;
	}

	public void setAudience(String audience) {
		this.audience = audience;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public int getExpiryMinutes() {
		return expiryMinutes;
	}

	public void setExpiryMinutes(int expiryMinutes) {
		this.expiryMinutes = expiryMinutes;
	}

	public List<String> getSecuritySchemes() {
		return securitySchemes;
	}

	public void setSecuritySchemes(List<String> securitySchemes) {
		this.securitySchemes = securitySchemes;
	}


}
