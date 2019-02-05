package org.foodauthent.people;

import java.util.Collection;

import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.EntityNotFoundException;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;

public interface OrganizationService {

	Organization add(Organization organization) throws EntityAlreadyExistsException, ServiceException;

	void deleteRecursive(Organization organization) throws EntityNotFoundException, InvalidOperationException, ServiceException;

	void delete(Organization organization) throws EntityNotFoundException, InvalidOperationException, ServiceException;

	Organization update(Organization organization) throws EntityNotFoundException, ServiceException;

	Organization get(String dn) throws EntityNotFoundException, ServiceException;

	Collection<Organization> search(String s);
	
}
