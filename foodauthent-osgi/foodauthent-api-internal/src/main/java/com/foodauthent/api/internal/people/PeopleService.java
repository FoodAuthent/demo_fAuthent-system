package com.foodauthent.api.internal.people;

import java.util.Collection;

import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.EntityNotFoundException;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;

public interface PeopleService <T> {

	T add(T p)
			throws EntityAlreadyExistsException, ServiceException;

	void delete(T p)
			throws EntityNotFoundException, InvalidOperationException, ServiceException;

	void deleteRecursive(T p)
			throws EntityNotFoundException, InvalidOperationException, ServiceException;

	T update(T p)
			throws EntityNotFoundException, ServiceException;

	T get(String dn) throws EntityNotFoundException, ServiceException;

	Collection<T> search(String s);

	T newEntryInstance(final String identifier);

}
