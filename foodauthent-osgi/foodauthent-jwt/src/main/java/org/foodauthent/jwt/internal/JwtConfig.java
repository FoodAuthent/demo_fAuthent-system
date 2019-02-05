package org.foodauthent.jwt.internal;

public class JwtConfig {
	
    private String secrect;
    
    private String audience;
    
    private String issuer;

    private int expiryMinutes = 120;
    
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


}
