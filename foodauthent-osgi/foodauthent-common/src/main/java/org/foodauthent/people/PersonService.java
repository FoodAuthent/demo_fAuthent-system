package org.foodauthent.people;

import java.util.Collection;

import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.EntityNotFoundException;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;

public interface PersonService {
	
	Person add(Person person) throws EntityAlreadyExistsException, ServiceException;

	void deleteRecursive(Person person) throws EntityNotFoundException, InvalidOperationException, ServiceException;

	void delete(Person person) throws EntityNotFoundException, InvalidOperationException, ServiceException;

	Person update(Person person) throws EntityNotFoundException, ServiceException;

	Person get(String dn) throws EntityNotFoundException, ServiceException;

	Collection<Person> search(String s);
}
