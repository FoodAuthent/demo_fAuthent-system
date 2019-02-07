package org.foodauthent.impl.user;

import org.foodauthent.api.UserService;
import org.foodauthent.api.internal.exception.EntityNotFoundException;
import org.foodauthent.auth.service.AuthenticationService;
import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.FAExceptions.ModelAlreadyExistsResponse;
import org.foodauthent.common.exception.FAExceptions.ModelNotFoundResponse;
import org.foodauthent.common.exception.FAExceptions.FAException;
import org.foodauthent.common.exception.FAExceptions.ForbiddenAccessResponse;
import org.foodauthent.common.exception.FAExceptions.InvalidOperationResponse;
import org.foodauthent.common.exception.FAExceptions.UnauthorizedResponse;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.common.exception.UnauthorizedException;
import org.foodauthent.model.ChangePasswordRequest;
import org.foodauthent.model.User;
import org.foodauthent.model.UserBase;
import org.foodauthent.model.UserCreateRequest;
import org.foodauthent.model.UserGroup;
import org.foodauthent.model.UserGroupBase;
import org.foodauthent.model.UserGroupCreateRequest;
import org.foodauthent.people.Group;
import org.foodauthent.people.Person;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import com.foodauthent.api.internal.people.GroupService;
import com.foodauthent.api.internal.people.PasswordService;
import com.foodauthent.api.internal.people.PersonService;

@Component(service = UserService.class, immediate = true)
public class UserServiceImpl implements UserService {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersonService<Person> personService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PasswordService passwordService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private AuthenticationService authenticationService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private GroupService<Group> groupService;

    @Override
    public User createUser(UserCreateRequest userCreateRequest) throws UnauthorizedResponse, ForbiddenAccessResponse,
	    ModelAlreadyExistsResponse, InvalidOperationResponse, FAException {
	final String dn = "uid=" + userCreateRequest.getUserName() + "," //
	// add ou=users if required
		+ (userCreateRequest.getParentDn().startsWith("ou=users") ? "" : "ou=users,") //
		+ userCreateRequest.getParentDn();
	final Person person = Convert.toPerson(dn, userCreateRequest, personService);
	try {
	    return Convert.toRestUser(personService.add(person));
	} catch (EntityAlreadyExistsException e) {
	    throw new ModelAlreadyExistsResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public UserGroup createUserGroup(UserGroupCreateRequest userGroupCreateRequest) throws UnauthorizedResponse,
	    ForbiddenAccessResponse, ModelAlreadyExistsResponse, InvalidOperationResponse, FAException {
	try {
	    final Group ldapGroup = Convert.toLdapGroup(userGroupCreateRequest, groupService);
	    return Convert.toRestUserGroup(groupService.add(ldapGroup));
	} catch (EntityAlreadyExistsException e) {
	    throw new ModelAlreadyExistsResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public void deleteUser(String dn) throws UnauthorizedResponse, ForbiddenAccessResponse, ModelNotFoundResponse,
	    InvalidOperationResponse, FAException {
	try {
	    personService.delete(personService.get(dn));
	} catch (EntityNotFoundException e) {
	    throw new ModelNotFoundResponse(e.getMessage(), e);
	} catch (InvalidOperationException e) {
	    throw new InvalidOperationResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public void deleteUserGroup(String dn) throws UnauthorizedResponse, ForbiddenAccessResponse, ModelNotFoundResponse,
	    InvalidOperationResponse, FAException {
	try {
	    groupService.delete(groupService.get(dn));
	} catch (EntityNotFoundException e) {
	    throw new ModelNotFoundResponse(e.getMessage(), e);
	} catch (InvalidOperationException e) {
	    throw new InvalidOperationResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public String generatePassword(String dn, Integer length)
	    throws UnauthorizedResponse, ForbiddenAccessResponse, ModelNotFoundResponse, FAException {
	try {
	    final int pwlen = length != null ? length.intValue() : 8;
	    return passwordService.generatePassword(dn, pwlen);
	} catch (UnauthorizedException e) {
	    throw new UnauthorizedResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public User getUser(String dn)
	    throws UnauthorizedResponse, ForbiddenAccessResponse, ModelNotFoundResponse, FAException {
	try {
	    final Person person = personService.get(dn);
	    return Convert.toRestUser(person);
	} catch (EntityNotFoundException e) {
	    throw new ModelNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public UserGroup getUserGroup(String dn)
	    throws UnauthorizedResponse, ForbiddenAccessResponse, ModelNotFoundResponse, FAException {
	try {
	    return Convert.toRestUserGroup(groupService.get(dn));
	} catch (EntityNotFoundException e) {
	    throw new ModelNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public void setPassword(String dn, ChangePasswordRequest changePasswordRequest)
	    throws UnauthorizedResponse, ForbiddenAccessResponse, ModelNotFoundResponse, FAException {
	try {
	    final Person ldapPerson = personService.get(dn);
	    authenticationService.authenticate(ldapPerson.getUserName(), changePasswordRequest.getCurrent());
	    passwordService.setPassword(dn, changePasswordRequest.getNew());
	} catch (UnauthorizedException e) {
	    throw new UnauthorizedResponse(e.getMessage(), e);
	} catch (EntityNotFoundException e) {
	    throw new ModelNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public User updateUser(String dn, UserBase userBase) throws UnauthorizedResponse, ForbiddenAccessResponse,
	    ModelNotFoundResponse, InvalidOperationResponse, FAException {
	try {
	    final Person person = Convert.toPerson(dn, userBase, personService);
	    return Convert.toRestUser(personService.update(person));
	} catch (EntityNotFoundException e) {
	    throw new ModelNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }

    @Override
    public UserGroup updateUserGroup(String dn, UserGroupBase userGroupBase) throws UnauthorizedResponse,
	    ForbiddenAccessResponse, ModelNotFoundResponse, InvalidOperationResponse, FAException {
	try {
	    return Convert.toRestUserGroup(groupService.update(Convert.toLdapGroup(userGroupBase, dn, groupService)));
	} catch (EntityNotFoundException e) {
	    throw new ModelNotFoundResponse(e.getMessage(), e);
	} catch (ServiceException e) {
	    throw new FAException(e.getMessage(), e);
	}
    }
}
