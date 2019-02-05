package org.foodauthent.ldap;

import java.util.Collection;
import java.util.List;

import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.EntityNotFoundException;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.ldap.beans.LdapGroup;
import org.ldaptive.LdapEntry;

public interface LdapGroupService extends LdapEntryService<LdapGroup> {

	/**
	 * list of LdapGroups the given user's dn is member of
	 * 
	 * @param userDn
	 * @return
	 * @throws ServiceException
	 */
	List<LdapGroup> getUserGroups(String userDn) throws ServiceException;

	/**
	 * list all available groups
	 * 
	 * @return
	 * @throws ServiceException
	 */
	List<LdapGroup> list() throws ServiceException;

	/**
	 * add new LdapGroup to LDAP Server
	 * 
	 * @param ldapGroup
	 *            new LdapGroup entity
	 * @throws EntityAlreadyExistsException
	 *             group with commonName already exists
	 * @throws ServiceException
	 *             LDAP Server API caused Exception
	 */
	LdapGroup add(LdapGroup ldapGroup) throws EntityAlreadyExistsException, ServiceException;

	void deleteRecursive(LdapGroup ldapGroup)
			throws EntityNotFoundException, InvalidOperationException, ServiceException;

	void delete(LdapGroup ldapGroup) throws EntityNotFoundException, InvalidOperationException, ServiceException;

	LdapGroup update(LdapGroup ldapGroup) throws EntityNotFoundException, ServiceException;

	LdapGroup get(String dn) throws EntityNotFoundException, ServiceException;

	LdapGroup map(LdapEntry entry);

	Collection<LdapGroup> search(String s);

	LdapGroup newEntryInstance();

}