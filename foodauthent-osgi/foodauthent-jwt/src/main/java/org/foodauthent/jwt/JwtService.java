package org.foodauthent.jwt;

import org.foodauthent.auth.User;
import org.foodauthent.common.exception.UnauthorizedException;

public interface JwtService {

	public User verify(String token) throws UnauthorizedException;
	
	public String refresh(String token) throws UnauthorizedException;

	public String create(User user) throws UnauthorizedException;

}
