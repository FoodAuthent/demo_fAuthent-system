package org.foodauthent.ldap;

import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.common.exception.UnauthorizedException;
import org.foodauthent.ldap.beans.LdapPerson;


public interface LdapAuthenticationService {

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return user's LDAP dn
	 * @throws UnauthorizedException
	 *             authorization failure
	 * @throws ServiceException
	 *             some LDAP error occured
	 */
	String authenticate(String userName, String password) throws UnauthorizedException, ServiceException;

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return LDAP Person Entry
	 * @throws UnauthorizedException
	 *             authorization failure
	 * @throws ServiceException
	 *             some LDAP error occured
	 */
	LdapPerson authenticatePerson(String userName, String password) throws UnauthorizedException, ServiceException;

	String resolve(String user) throws ServiceException;

}