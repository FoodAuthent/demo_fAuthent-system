package org.foodauthent.ldap;

import java.util.List;

import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.ldap.beans.LdapGroup;

import com.foodauthent.api.internal.people.GroupService;

public interface LdapGroupService extends LdapEntryService<LdapGroup>, GroupService<LdapGroup> {

	/**
	 * list of LdapGroups the given user's dn is member of
	 * 
	 * @param userDn
	 * @return
	 * @throws ServiceException
	 */
	List<LdapGroup> getUserGroups(String userDn) throws ServiceException;

	List<LdapGroup> list() throws ServiceException;

}