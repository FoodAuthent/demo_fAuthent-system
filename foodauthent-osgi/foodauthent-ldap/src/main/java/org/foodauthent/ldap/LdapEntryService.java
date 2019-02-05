package org.foodauthent.ldap;

import java.util.Collection;

import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.EntityNotFoundException;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;
import org.ldaptive.LdapEntry;

public interface LdapEntryService<T> {

	T add(T v) throws EntityAlreadyExistsException, ServiceException;

	void deleteRecursive(T v) throws EntityNotFoundException, InvalidOperationException, ServiceException;

	void delete(T v) throws EntityNotFoundException, InvalidOperationException, ServiceException;

	T update(T v) throws EntityNotFoundException, ServiceException;

	T get(String dn) throws EntityNotFoundException, ServiceException;

	T map(LdapEntry entry);

	String[] getReturnAttributes();

	Collection<T> search(String s);

	Class<T> getEntryClass();

	T newEntryInstance();

}