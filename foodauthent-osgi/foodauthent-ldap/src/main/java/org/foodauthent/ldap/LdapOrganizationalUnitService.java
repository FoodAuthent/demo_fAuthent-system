package org.foodauthent.ldap;

import org.foodauthent.ldap.beans.LdapOrganizationalUnit;

import com.foodauthent.api.internal.people.OrganizationalUnitService;

public interface LdapOrganizationalUnitService extends LdapEntryService<LdapOrganizationalUnit>, OrganizationalUnitService<LdapOrganizationalUnit> {

}