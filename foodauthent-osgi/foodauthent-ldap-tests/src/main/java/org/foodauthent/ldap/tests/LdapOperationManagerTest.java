package org.foodauthent.ldap.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.foodauthent.ldap.LdapOperationManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ldaptive.Connection;

public class LdapOperationManagerTest extends AbstractLdapServiceTest {
	
	private static LdapOperationManager pooledLdapOperationService;
	
	@BeforeAll
    static void setUpBeforeClass() throws Exception {
		pooledLdapOperationService = getService(LdapOperationManager.class);
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @Test()
    @DisplayName("Get Connection")
    void test1() throws Exception {
    	Connection conn =  pooledLdapOperationService.getConnection();
    	assertNotNull(conn);
    	conn.close();
    }
}
