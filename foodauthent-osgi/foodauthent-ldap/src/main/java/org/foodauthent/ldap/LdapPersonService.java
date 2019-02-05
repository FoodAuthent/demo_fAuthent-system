package org.foodauthent.ldap;

import java.util.Collection;

import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.EntityNotFoundException;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.ldap.beans.LdapPerson;
import org.ldaptive.LdapEntry;

public interface LdapPersonService extends LdapEntryService<LdapPerson> {

	LdapPerson add(LdapPerson ldapPerson) throws EntityAlreadyExistsException, ServiceException;

	void deleteRecursive(LdapPerson ldapPerson)
			throws EntityNotFoundException, InvalidOperationException, ServiceException;

	void delete(LdapPerson ldapPerson) throws EntityNotFoundException, InvalidOperationException, ServiceException;

	LdapPerson update(LdapPerson ldapPerson) throws EntityNotFoundException, ServiceException;

	LdapPerson get(String dn) throws EntityNotFoundException, ServiceException;

	LdapPerson map(LdapEntry entry);

	String[] getReturnAttributes();

	Collection<LdapPerson> search(String s);

	LdapPerson newEntryInstance();
}