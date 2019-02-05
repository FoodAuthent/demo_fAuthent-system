package org.foodauthent.ldap.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.foodauthent.common.exception.EntityNotFoundException;
import org.foodauthent.ldap.DnUtil;
import org.foodauthent.ldap.LdapGroupService;
import org.foodauthent.ldap.LdapOperationManager;
import org.foodauthent.ldap.LdapPersonService;
import org.foodauthent.ldap.beans.LdapGroup;
import org.foodauthent.ldap.beans.LdapPerson;
import org.foodauthent.ldap.config.LDAPConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LdapGroupServiceTest extends AbstractLdapServiceTest {

	private static LdapOperationManager pooledLdapOperationService;

	private static LdapGroupService LdapGroupService;

	private static LdapPersonService ldapPersonService;

	private static LDAPConfig config;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		config = ldapConfig();
		pooledLdapOperationService = getService(LdapOperationManager.class);
		LdapGroupService = getService(LdapGroupService.class);
		ldapPersonService = getService(LdapPersonService.class);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test()
	@DisplayName("CRUD Group")
	void test1() throws Exception {
		final String serial = "" + System.currentTimeMillis();
		// create test user for group
		final String userName = "junit-user-" + serial;
		final LdapPerson p = ldapPersonService.add(ldapUser(userName));
		assertNotNull(p);
		assertTrue(pooledLdapOperationService.entryExists(p.getDn()));

		// create new test group
		final String groupName = "junit-group-" + serial;
		final LdapGroup create = ldapGroup(groupName);
		// add member to group
		create.setGroupMembers(Arrays.asList(p.getDn()));
		final String dn = DnUtil.buildDn(config.getGroupDn(), "cn", groupName);
		create.setDn(dn);

		// test if non-existing group causes Exception
		assertThrows(EntityNotFoundException.class, () -> {
			LdapGroupService.get(create.getDn());
		});
		assertThrows(EntityNotFoundException.class, () -> {
			LdapGroupService.update(create);
		});

		// reset dn for later validation (must have been set by service when adding)
		create.setDn(null);
		final LdapGroup created = LdapGroupService.add(create);
		assertNotNull(created);
		assertTrue(dn.equals(created.getDn()));

		// test if new group exists
		final LdapGroup found = LdapGroupService.get(created.getDn());
		assertNotNull(found);
		assertTrue(create.getName().equals(found.getName()));
		Collection<LdapGroup> searchResult = LdapGroupService.search(serial);
		assertTrue(searchResult.contains(found));
		assertTrue(LdapGroupService.list().contains(found));
		
		// test if user is in group
		assertTrue(LdapGroupService.getUserGroups(p.getDn()).contains(found));

		// change group name
		final String changedGroupName = "changed-" + groupName;
		found.setName(changedGroupName);
		final LdapGroup changed = LdapGroupService.update(found);
		assertNotNull(changed);
		assertTrue(changed.getName().equals(changedGroupName));
		assertTrue(changed.getDn().equals(DnUtil.buildDn(config.getGroupDn(), "cn", changedGroupName)));
		// test if user is in changed group
		assertTrue(LdapGroupService.getUserGroups(p.getDn()).contains(changed));


		// test if trying to operate on old group fails
		assertFalse(pooledLdapOperationService.entryExists(created.getDn()));
		assertFalse(LdapGroupService.search(serial).contains(created));
		assertFalse(LdapGroupService.list().contains(created));
		assertThrows(EntityNotFoundException.class, () -> {
			LdapGroupService.get(created.getDn());
		});
		assertThrows(EntityNotFoundException.class, () -> {
			LdapGroupService.update(created);
		});

		// delete group
		LdapGroupService.delete(changed);
		assertFalse(pooledLdapOperationService.entryExists(changed.getDn()));

		ldapPersonService.delete(p);
		assertFalse(pooledLdapOperationService.entryExists(p.getDn()));
	}
}
