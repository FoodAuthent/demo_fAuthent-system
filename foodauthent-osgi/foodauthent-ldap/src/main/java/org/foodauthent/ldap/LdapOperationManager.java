package org.foodauthent.ldap;

import java.util.Optional;

import org.ldaptive.Connection;
import org.ldaptive.LdapEntry;
import org.ldaptive.LdapException;
import org.ldaptive.SearchResult;
import org.ldaptive.SearchScope;
import org.ldaptive.pool.PooledConnectionFactory;

public interface LdapOperationManager {

	Connection getConnection() throws LdapException;

	PooledConnectionFactory getConnectionFactory();

	Optional<LdapEntry> getEntry(String dn, String... returnAttributes);

	boolean entryExists(String dn);

	SearchResult search(final String dn, final String filter, final SearchScope scope, final String... returnAttributes)
			throws LdapException;

	void delete(String dn) throws LdapException;

}