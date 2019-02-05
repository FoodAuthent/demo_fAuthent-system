package org.foodauthent.ldap.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.EntityNotFoundException;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.ldap.DnUtil;
import org.foodauthent.ldap.LdapOperationManager;
import org.foodauthent.ldap.LdapOrganizationalUnitService;
import org.foodauthent.ldap.beans.LdapOrganizationalUnit;
import org.foodauthent.ldap.config.LDAPConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LdapOrganizationalUnitServiceTest extends AbstractLdapServiceTest {

	private static LdapOperationManager pooledLdapOperationService;

	private static LdapOrganizationalUnitService ldapOrganizationalUnitService;

	private static LDAPConfig config;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		config = ldapConfig();
		pooledLdapOperationService = getService(LdapOperationManager.class);
		ldapOrganizationalUnitService = getService(LdapOrganizationalUnitService.class);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test()
	@DisplayName("CRUD OrganizationalUnit")
	void testCrud() throws Exception {
		final String serial = "" + System.currentTimeMillis();

		// setup new organizationalUnit
		final String orginationalUnitName = "JUnit-org-" + serial;
		final LdapOrganizationalUnit create = ldapOrganizationalUnit(orginationalUnitName);
		final String dn = create.getDn();

		// test Constructors
		assertTrue(create.getDn().equals(new LdapOrganizationalUnit(create.getDn()).getDn()));
		assertTrue(create.getDn().equals(new LdapOrganizationalUnit(config.getBaseDn(), orginationalUnitName).getDn()));

		// test organization doesn't exist
		assertFalse(pooledLdapOperationService.entryExists(dn));

		// test if update on non-existing organization causes Exception
		assertThrows(EntityNotFoundException.class, () -> {
			ldapOrganizationalUnitService.update(create);
		});

		// test if delete on non-existing organization causes Exception
		assertThrows(EntityNotFoundException.class, () -> {
			ldapOrganizationalUnitService.delete(create);
		});

		// create new organization
		final LdapOrganizationalUnit created = ldapOrganizationalUnitService.add(create);
		assertNotNull(created);
		assertTrue(dn.equals(created.getDn()));

		// test organization exists
		assertTrue(pooledLdapOperationService.entryExists(dn));

		// test if organization can be added twice
		assertThrows(EntityAlreadyExistsException.class, () -> {
			ldapOrganizationalUnitService.add(create);
		});

		// test get LdapEntry for organization
		assertTrue(pooledLdapOperationService.getEntry(dn).isPresent());

		// test is dn for users and groups exist
		assertTrue(pooledLdapOperationService.getEntry(String.join(",", LdapOrganizationalUnit.OU_USERS, dn)).isPresent());
		assertTrue(pooledLdapOperationService.getEntry(String.join(",", LdapOrganizationalUnit.OU_GROUPS, dn)).isPresent());

		// test get LdapOrganizationalUnit Object for organization
		LdapOrganizationalUnit found = ldapOrganizationalUnitService.get(dn);
		assertNotNull(found);
		found.setLocalityName("JUnit Change");
		found.setDescription("new description");
		LdapOrganizationalUnit changed = ldapOrganizationalUnitService.update(found);
		assertNotNull(changed);
		assertTrue(found.getLocalityName().equals(changed.getLocalityName()));
		assertTrue(found.getDescription().equals(changed.getDescription()));

		// test "hasChildren" throw exception
		final String childName = "Child of " + orginationalUnitName;
		LdapOrganizationalUnit child = new LdapOrganizationalUnit(created.getDn(), childName);
		LdapOrganizationalUnit childCreated = ldapOrganizationalUnitService.add(child);
		assertTrue(child.getDn().equals(childCreated.getDn()));
		// test if organization cannot be deleted if it has children
		assertThrows(InvalidOperationException.class, () -> {
			ldapOrganizationalUnitService.delete(created);
		});
		ldapOrganizationalUnitService.delete(childCreated);
		assertFalse(pooledLdapOperationService.entryExists(childCreated.getDn()));

		// delete description attribute
		found.setDescription(null);
		changed = ldapOrganizationalUnitService.update(found);
		assertNotNull(changed);
		assertTrue(found.getLocalityName().equals(changed.getLocalityName()));
		assertTrue(changed.getDescription() == null);

		// test change organization name
		found.setName("Change " + found.getName());
		LdapOrganizationalUnit changedName = ldapOrganizationalUnitService.update(found);
		assertNotNull(changedName);
		assertTrue(found.getName().equals(changedName.getName()));
		// dn should have moved
		assertFalse(create.getDn().equals(changedName.getDn()));

		// delete organization
		ldapOrganizationalUnitService.delete(found);
		assertFalse(pooledLdapOperationService.entryExists(found.getDn()));

		// test search and recursive delete operation
		final LdapOrganizationalUnit root = ldapOrganizationalUnit("JUnit Root " + serial);
		final String rootDn = root.getDn();
		LdapOrganizationalUnit rootCreated = ldapOrganizationalUnitService.add(root);
		assertNotNull(rootCreated);
		assertTrue(rootDn.equals(rootCreated.getDn()));
		Set<LdapOrganizationalUnit> searchOrgs = new HashSet<LdapOrganizationalUnit>();
		searchOrgs.add(rootCreated);
		LdapOrganizationalUnit parent = rootCreated;
		for (int i = 0; i < 10; i++) {
			final LdapOrganizationalUnit next = ldapOrganizationalUnit("JUnit Child " + serial + "-" + i);
			next.setDn(DnUtil.buildDn(parent.getDn(), "ou", next.getName()));
			final LdapOrganizationalUnit nextCreated = ldapOrganizationalUnitService.add(next);
			assertNotNull(nextCreated);
			assertTrue(next.getDn().equals(nextCreated.getDn()));
			assertTrue(parent.getDn().equals(DnUtil.parentDn(nextCreated.getDn())));
			// test if parent organization cannot be deleted if it has children
			final LdapOrganizationalUnit theParent = parent;
			assertThrows(InvalidOperationException.class, () -> {
				ldapOrganizationalUnitService.delete(theParent);
			});
			searchOrgs.add(nextCreated);
			parent = nextCreated;
		}
		// test search on create organizations
		assertTrue(ldapOrganizationalUnitService.search(serial).containsAll(searchOrgs));
		
		// test if root organization cannot be deleted if it has children
		assertThrows(InvalidOperationException.class, () -> {
			ldapOrganizationalUnitService.delete(root);
		});
		// finally delete recursive
		ldapOrganizationalUnitService.deleteRecursive(root);
		assertFalse(pooledLdapOperationService.entryExists(root.getDn()));
	}


}
