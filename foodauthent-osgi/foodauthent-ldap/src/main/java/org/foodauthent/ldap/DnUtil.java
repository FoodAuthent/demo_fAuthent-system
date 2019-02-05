package org.foodauthent.ldap;

import org.foodauthent.ldap.beans.LdapOrganizationalUnit;
import org.foodauthent.ldap.beans.LdapPerson;

public class DnUtil {

	public static final String parentDn(final String dn) {
		if (dn.indexOf(",") != -1) {
			return dn.substring(dn.indexOf(",") + 1);
		}
		return dn;
	}

	public static final String updateDn(final String currentDn, final String attribute, final String attributeValue) {
		if (currentDn == null) {
			return null;
		}
		final String baseDn = parentDn(currentDn);
		return buildDn(baseDn, attribute, attributeValue);
	}

	public static final String buildDn(final String baseDn, final String attribute, final String attributeValue) {
		return attribute + "=" + attributeValue + "," + baseDn;
	}

	public static final String getOrganizationalUnitDn(final LdapPerson person) {
		int index = person.getDn().indexOf("ou=");
		if (index != -1) {
			String orgDn = person.getDn().substring(index);
			// walk up OUs for groups and users
			index = orgDn.indexOf("ou=");
			while (index != -1 && (orgDn.indexOf(LdapOrganizationalUnit.OU_GROUPS) == 0
					|| orgDn.indexOf(LdapOrganizationalUnit.OU_USERS) == 0)) {
				orgDn = orgDn.substring(index);
				index = orgDn.indexOf("ou=", 4);
			}
			if ((orgDn.indexOf(LdapOrganizationalUnit.OU_GROUPS) != 0
					&& orgDn.indexOf(LdapOrganizationalUnit.OU_USERS) != 0)) {
				return orgDn;
			}
		}
		return null;
	}

}
