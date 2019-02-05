package org.foodauthent.auth.service;

import org.foodauthent.auth.User;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.common.exception.UnauthorizedException;

public interface AuthenticationService {

	User authenticate(String userName, String password) throws UnauthorizedException, ServiceException;

}