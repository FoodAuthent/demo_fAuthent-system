package org.foodauthent.impl.user;

import org.foodauthent.api.UserService;
import org.foodauthent.api.internal.exception.EntityNotFoundException;
import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.FAExceptions.EntityAlreadyExistsResponse;
import org.foodauthent.common.exception.FAExceptions.EntityNotFoundResponse;
import org.foodauthent.common.exception.FAExceptions.FAException;
import org.foodauthent.common.exception.FAExceptions.ForbiddenAccessResponse;
import org.foodauthent.common.exception.FAExceptions.InvalidOperationResponse;
import org.foodauthent.common.exception.FAExceptions.UnauthorizedResponse;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.common.exception.UnauthorizedException;
import org.foodauthent.ldap.LdapAuthenticationService;
import org.foodauthent.ldap.LdapGroupService;
import org.foodauthent.ldap.LdapPasswordService;
import org.foodauthent.ldap.LdapPersonService;
import org.foodauthent.ldap.beans.LdapGroup;
import org.foodauthent.ldap.beans.LdapPerson;
import org.foodauthent.model.ChangePasswordRequest;
import org.foodauthent.model.User;
import org.foodauthent.model.UserBase;
import org.foodauthent.model.UserCreateRequest;
import org.foodauthent.model.UserGroup;
import org.foodauthent.model.UserGroupBase;
import org.foodauthent.model.UserGroupCreateRequest;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(service = UserService.class, immediate = true)
public class UserServiceImpl implements UserService {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private LdapPersonService ldapPersonService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private LdapPasswordService ldapPasswordService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private LdapAuthenticationService ldapAuthenticationService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private LdapGroupService ldapGroupService;
    
    @Override
    public User createUser(UserCreateRequest userCreateRequest) throws UnauthorizedResponse, ForbiddenAccessResponse,
	    EntityAlreadyExistsResponse, InvalidOperationResponse, FAException {
	final String dn = "uid=" + userCreateRequest.getUserName() + "," //
	// add ou=users if required
		+ (userCreateRequest.getParentDn().startsWith("ou=users") ? "" : "ou=users,") //
		+ userCreateRequest.getParentDn();
	final LdapPerson person = Convert.toLdapPerson(dn, userCreateRequest);
	try {
	    return Convert.toRestUser(ldapPersonService.add(person));
	} catch (EntityAlreadyExistsException e) {
	    throw new EntityAlreadyExistsResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public UserGroup createUserGroup(UserGroupCreateRequest userGroupCreateRequest) throws UnauthorizedResponse,
	    ForbiddenAccessResponse, EntityAlreadyExistsResponse, InvalidOperationResponse, FAException {
	try {
	    final LdapGroup ldapGroup = Convert.toLdapGroup(userGroupCreateRequest);
	    return Convert.toRestUserGroup(ldapGroupService.add(ldapGroup));
	} catch (EntityAlreadyExistsException e) {
	    throw new EntityAlreadyExistsResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public void deleteUser(String dn) throws UnauthorizedResponse, ForbiddenAccessResponse, EntityNotFoundResponse,
	    InvalidOperationResponse, FAException {
	try {
	    ldapPersonService.delete(ldapPersonService.get(dn));
	} catch (EntityNotFoundException e) {
	    throw new EntityNotFoundResponse(e.getMessage(), e);
	} catch (InvalidOperationException e) {
	    throw new InvalidOperationResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public void deleteUserGroup(String dn) throws UnauthorizedResponse, ForbiddenAccessResponse, EntityNotFoundResponse,
	    InvalidOperationResponse, FAException {
	try {
	    ldapGroupService.delete(ldapGroupService.get(dn));
	} catch (EntityNotFoundException e) {
	    throw new EntityNotFoundResponse(e.getMessage(), e);
	} catch (InvalidOperationException e) {
	    throw new InvalidOperationResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public String generatePassword(String dn, Integer length)
	    throws UnauthorizedResponse, ForbiddenAccessResponse, EntityNotFoundResponse, FAException {
	try {
	    final int pwlen = length != null ? length.intValue() : 8;
	    return ldapPasswordService.generatePassword(dn, pwlen);
	} catch (UnauthorizedException e) {
	    throw new UnauthorizedResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public User getUser(String dn)
	    throws UnauthorizedResponse, ForbiddenAccessResponse, EntityNotFoundResponse, FAException {
	try {
	    final LdapPerson person = ldapPersonService.get(dn);
	    return Convert.toRestUser(person);
	} catch (EntityNotFoundException e) {
	    throw new EntityNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public UserGroup getUserGroup(String dn)
	    throws UnauthorizedResponse, ForbiddenAccessResponse, EntityNotFoundResponse, FAException {
	try {
	    return Convert.toRestUserGroup(ldapGroupService.get(dn));
	} catch (EntityNotFoundException e) {
	    throw new EntityNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public void setPassword(String dn, ChangePasswordRequest changePasswordRequest)
	    throws UnauthorizedResponse, ForbiddenAccessResponse, EntityNotFoundResponse, FAException {
	try {
		final LdapPerson ldapPerson = ldapPersonService.get(dn);
		ldapAuthenticationService.authenticate(ldapPerson.getUserName(), changePasswordRequest.getCurrent());
		ldapPasswordService.setPassword(dn, changePasswordRequest.getNew());
	} catch (UnauthorizedException e) {
		throw new UnauthorizedResponse(e.getMessage(), e);
	} catch (EntityNotFoundException e) {
		throw new EntityNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
		throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public User updateUser(String dn, UserBase userBase) throws UnauthorizedResponse, ForbiddenAccessResponse,
	    EntityNotFoundResponse, InvalidOperationResponse, FAException {
	try {
		final LdapPerson person = Convert.toLdapPerson(dn, userBase);
		return Convert.toRestUser(ldapPersonService.update(person));
	} catch (EntityNotFoundException e) {
		throw new EntityNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
		throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public UserGroup updateUserGroup(String dn, UserGroupBase userGroupBase) throws UnauthorizedResponse,
	    ForbiddenAccessResponse, EntityNotFoundResponse, InvalidOperationResponse, FAException {
	try {
		return Convert.toRestUserGroup(ldapGroupService.update(Convert.toLdapGroup(userGroupBase, dn)));
	} catch (EntityNotFoundException e) {
		throw new EntityNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
		throw new FAException(e.getMessage(), e);
	}
    }
}
