package org.foodauthent.ldap.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.EntityNotFoundException;
import org.foodauthent.ldap.LdapOperationManager;
import org.foodauthent.ldap.LdapPersonService;
import org.foodauthent.ldap.beans.LdapPerson;
import org.foodauthent.ldap.config.LDAPConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LdapPersonServiceTest extends AbstractLdapServiceTest {

	private static LdapOperationManager pooledLdapOperationService;

	private static LdapPersonService ldapPersonService;

	private static LDAPConfig config;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		config = ldapConfig();
		pooledLdapOperationService = getService(LdapOperationManager.class);
		ldapPersonService = getService(LdapPersonService.class);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test()
	@DisplayName("CRUD Person")
	void testCrud() throws Exception {
		final String serial = "" + System.currentTimeMillis();
		// setup new user person
		final String userName = "JUnit User " + serial;
		final LdapPerson create = ldapUser(userName);
		final String dn = create.getDn();

		// test Constructors
		assertTrue(create.getDn().equals(new LdapPerson(create.getDn()).getDn()));
		assertTrue(create.getDn().equals(new LdapPerson("ou=users," + config.getBaseDn(), userName).getDn()));

		// test user doesn't exist
		assertFalse(pooledLdapOperationService.entryExists(dn));

		// test if update on non-existing user causes Exception
		assertThrows(EntityNotFoundException.class, () -> {
			ldapPersonService.update(create);
		});

		// test if delete on non-existing user causes Exception
		assertThrows(EntityNotFoundException.class, () -> {
			ldapPersonService.delete(create);
		});

		// create new user
		final LdapPerson created = ldapPersonService.add(create);
		assertNotNull(created);
		assertTrue(dn.equals(created.getDn()));

		// test user exists
		assertTrue(pooledLdapOperationService.entryExists(dn));

		// test if user can be added twice
		assertThrows(EntityAlreadyExistsException.class, () -> {
			ldapPersonService.add(create);
		});

		// test get LdapPerson Object for user
		LdapPerson found = ldapPersonService.get(dn);
		assertNotNull(found);
		found.setGivenName("JUnit Change");
		found.setDescription("new description");
		LdapPerson changed = ldapPersonService.update(found);
		assertNotNull(changed);
		assertTrue(found.getGivenName().equals(changed.getGivenName()));
		assertTrue(found.getDescription().equals(changed.getDescription()));

		// test change user name
		found.setUserName("Change " + found.getUserName());
		LdapPerson changedUserName = ldapPersonService.update(found);
		assertNotNull(changedUserName);
		assertTrue(found.getUserName().equals(changedUserName.getUserName()));
		assertTrue(found.getGivenName().equals(changedUserName.getGivenName()));
		assertTrue(found.getDescription().equals(changedUserName.getDescription()));

		// delete description attribute
		found.setDescription(null);
		changed = ldapPersonService.update(found);
		assertNotNull(changed);
		assertTrue(found.getGivenName().equals(changed.getGivenName()));
		assertTrue(changed.getDescription() == null);

		// test search
		assertTrue(ldapPersonService.search("JUnit").contains(found));

		// delete user
		ldapPersonService.delete(found);
		assertFalse(pooledLdapOperationService.entryExists(found.getDn()));
	}

}
