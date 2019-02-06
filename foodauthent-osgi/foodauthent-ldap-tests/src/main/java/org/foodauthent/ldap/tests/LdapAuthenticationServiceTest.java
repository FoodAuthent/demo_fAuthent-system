package org.foodauthent.ldap.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.foodauthent.common.exception.UnauthorizedException;
import org.foodauthent.ldap.LdapAuthenticationService;
import org.foodauthent.ldap.LdapOperationManager;
import org.foodauthent.ldap.LdapPersonService;
import org.foodauthent.ldap.beans.LdapPerson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.foodauthent.api.internal.people.PasswordService;

public class LdapAuthenticationServiceTest extends AbstractLdapServiceTest {

	private static LdapOperationManager pooledLdapOperationService;

	private static LdapPersonService ldapPersonService;

	private static LdapAuthenticationService ldapAuthService;

	private static PasswordService ldapPassService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		pooledLdapOperationService = getService(LdapOperationManager.class);
		ldapPersonService = getService(LdapPersonService.class);
		ldapAuthService = getService(LdapAuthenticationService.class);
		ldapPassService = getService(PasswordService.class);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test()
	@DisplayName("Auth User")
	public void testAuth() throws Exception {
		final String serial = "" + System.currentTimeMillis();
		// setup new user person
		final String userName = "JUnit User " + serial;
		final LdapPerson authUser = ldapUser(userName);
		assertNotNull(authUser);
		final String dn = authUser.getDn();
		assertNotNull(dn);
		ldapPersonService.add(authUser);
		final String newPass = ldapPassService.generatePassword(dn);
		final String authDn = ldapAuthService.authenticate(userName, newPass);
		assertNotNull(authDn);
		final LdapPerson p = ldapAuthService.authenticatePerson(userName, newPass);
		assertNotNull(p);
		ldapPassService.modifyPassword(p.getDn(), newPass, "JunitTestPass00");
		assertThrows(UnauthorizedException.class, () -> {
			ldapPassService.modifyPassword(p.getDn(), newPass, "JunitTestPass00");
		});
		assertThrows(UnauthorizedException.class, () -> {
			ldapPassService.modifyPassword(p.getDn(), newPass, "JunitTestPass00");
		});
		ldapPassService.setPassword(p.getDn(), "setpass");
		ldapPassService.modifyPassword(p.getDn(), "setpass", "JunitTestPass00");
		ldapPersonService.delete(authUser);
		assertFalse(pooledLdapOperationService.entryExists(authDn));
	}

}
