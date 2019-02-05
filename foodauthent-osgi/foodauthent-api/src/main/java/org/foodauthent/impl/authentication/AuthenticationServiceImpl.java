package org.foodauthent.impl.authentication;

import org.foodauthent.api.AuthenticationService;
import org.foodauthent.auth.User;
import org.foodauthent.common.exception.FAExceptions.FAException;
import org.foodauthent.common.exception.FAExceptions.UnauthorizedResponse;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.common.exception.UnauthorizedException;
import org.foodauthent.jwt.JwtService;
import org.foodauthent.model.UserAuthenticationRequest;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(service = AuthenticationService.class, immediate = true)
public class AuthenticationServiceImpl implements AuthenticationService {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private org.foodauthent.auth.service.AuthenticationService authenticationService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private JwtService jwtService;

    @Override
    public String authenticateUserJSONWebToken(UserAuthenticationRequest userAuthenticationRequest)
	    throws UnauthorizedResponse, FAException {
	try {
	    final User user = authenticationService.authenticate(userAuthenticationRequest.getUser(),
		    userAuthenticationRequest.getPassword());
	    final String token = jwtService.create(user);
	    return token;
	} catch (UnauthorizedException e) {
	    throw new UnauthorizedResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public String refreshJSONWebToken(String body) throws UnauthorizedResponse, FAException {
	try {
	    return jwtService.refresh(body);
	} catch (UnauthorizedException e) {
	    throw new UnauthorizedResponse(e.getMessage(), e);
	}
    }

    @Override
    public void verifyJSONWebToken(String body) throws UnauthorizedResponse, FAException {
	try {
	    jwtService.verify(body);
	} catch (UnauthorizedException e) {
	    throw new UnauthorizedResponse(e.getMessage(), e);
	}
    }

}
