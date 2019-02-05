package org.foodauthent.auth.ldap;

import org.foodauthent.auth.AbstractUserGroup;
import org.foodauthent.ldap.beans.LdapGroup;

public class LdapUserGroup extends AbstractUserGroup {

	LdapUserGroup(final LdapGroup ldapGroup) {
		super(ldapGroup.getName());
	}

}
