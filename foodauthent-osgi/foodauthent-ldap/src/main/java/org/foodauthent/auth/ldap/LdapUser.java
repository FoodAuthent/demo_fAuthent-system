package org.foodauthent.auth.ldap;

import java.util.Collection;

import org.foodauthent.auth.AbstractUser;
import org.foodauthent.auth.Organization;
import org.foodauthent.auth.UserGroup;
import org.foodauthent.ldap.beans.LdapPerson;

public class LdapUser extends AbstractUser {

	LdapUser(final LdapPerson person, final Organization organization, final Collection<UserGroup> groups) {
		super(person.getDn(), person.getUserName(), organization, groups);
	}

}
