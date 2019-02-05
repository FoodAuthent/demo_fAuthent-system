package org.foodauthent.auth.ldap;

import org.foodauthent.auth.AbstractUserOrganization;
import org.foodauthent.auth.Organization;
import org.foodauthent.ldap.beans.LdapOrganizationalUnit;

public class LdapUserOrganization extends AbstractUserOrganization {

	public static final Organization ROOT = new Organization() {

		@Override
		public String getName() {
			return "foodauthent.org";
		}

		@Override
		public String getIdentifier() {
			return "dc=foodauthent,dc=org";
		}
	};

	LdapUserOrganization(final LdapOrganizationalUnit organizationalUnit) {
		super(organizationalUnit.getDn(), organizationalUnit.getName());
	}

}
