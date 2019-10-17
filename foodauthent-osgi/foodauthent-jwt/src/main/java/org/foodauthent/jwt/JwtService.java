package org.foodauthent.jwt;

import org.foodauthent.auth.User;
import org.foodauthent.auth.UserPrincipal;
import org.foodauthent.auth.WebAuthenticationMethod;
import org.foodauthent.common.exception.UnauthorizedException;

public interface JwtService extends WebAuthenticationMethod {

	public UserPrincipal verifyToken(String token) throws UnauthorizedException;
	
	public String refreshToken(String token) throws UnauthorizedException;

	public String createToken(UserPrincipal user) throws UnauthorizedException;
	
	public String createToken(UserPrincipal user, int lifeTimeMinutes) throws UnauthorizedException;

	public String createToken(User user) throws UnauthorizedException;

	String createToken(User user, int lifeTime) throws UnauthorizedException;
}
