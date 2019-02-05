package org.foodauthent.ldap;

import java.util.Collection;

import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.EntityNotFoundException;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.ldap.beans.LdapOrganizationalUnit;
import org.ldaptive.LdapEntry;

public interface LdapOrganizationalUnitService extends LdapEntryService<LdapOrganizationalUnit> {

	LdapOrganizationalUnit add(LdapOrganizationalUnit organizationalUnit)
			throws EntityAlreadyExistsException, ServiceException;

	void delete(LdapOrganizationalUnit organizationalUnit)
			throws EntityNotFoundException, InvalidOperationException, ServiceException;

	void deleteRecursive(LdapOrganizationalUnit organizationalUnit)
			throws EntityNotFoundException, InvalidOperationException, ServiceException;

	LdapOrganizationalUnit update(LdapOrganizationalUnit organizationalUnit)
			throws EntityNotFoundException, ServiceException;

	LdapOrganizationalUnit get(String dn) throws EntityNotFoundException, ServiceException;

	LdapOrganizationalUnit map(LdapEntry entry);

	Collection<LdapOrganizationalUnit> search(String s);

	LdapOrganizationalUnit newEntryInstance();
}