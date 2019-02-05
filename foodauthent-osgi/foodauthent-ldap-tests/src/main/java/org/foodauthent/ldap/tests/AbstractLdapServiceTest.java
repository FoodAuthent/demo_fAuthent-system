package org.foodauthent.ldap.tests;

import java.util.Arrays;

import org.foodauthent.common.tests.base.AbstractServiceTest;
import org.foodauthent.ldap.beans.LdapGroup;
import org.foodauthent.ldap.beans.LdapOrganizationalUnit;
import org.foodauthent.ldap.beans.LdapPerson;
import org.foodauthent.ldap.config.LDAPConfig;


abstract class AbstractLdapServiceTest extends AbstractServiceTest {

	protected static LDAPConfig ldapConfig() {
		final LDAPConfig cfg = getService(LDAPConfig.class);
		return cfg;
	}
	
	protected LdapPerson ldapUser(String userName) {
		final LdapPerson user = new LdapPerson();
		final String dn = "uid=" + userName + ",ou=users," + ldapConfig().getBaseDn();
		user.setDn(dn);
		user.setDisplayName("Junit Test");
		user.setGivenName("Junit");
		user.setUserName(userName);
		user.setMail(Arrays.asList("mail@example.com"));
		user.setLastName("Test");
		user.setCommonName("junit-test");
		return user;
	}
	
	public LdapOrganizationalUnit ldapOrganizationalUnit(String organizationalUnitName) {
		final LdapOrganizationalUnit org = new LdapOrganizationalUnit();
		final String dn = "ou=" + String.join(",", organizationalUnitName, ldapConfig().getBaseDn());
		org.setDn(dn);
		org.setName(organizationalUnitName);
		org.setLocalityName("JUnit Locality");
		return org;
	}

	public LdapGroup ldapGroup(String commonName) {
		final LdapGroup group = new LdapGroup();
		group.setName(commonName);
		return group;
	}
}
