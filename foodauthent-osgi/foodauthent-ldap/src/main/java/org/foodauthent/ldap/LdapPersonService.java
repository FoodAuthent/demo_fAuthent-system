package org.foodauthent.ldap;

import org.foodauthent.ldap.beans.LdapPerson;

import com.foodauthent.api.internal.people.PersonService;

public interface LdapPersonService extends LdapEntryService<LdapPerson>, PersonService<LdapPerson> {

}