package org.foodauthent.ldap.internal;

import java.util.Set;
import java.util.stream.Collectors;

import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.ldap.LdapOperationManager;
import org.foodauthent.ldap.LdapPersonService;
import org.foodauthent.ldap.beans.LdapPerson;
import org.foodauthent.ldap.config.LDAPConfig;
import org.ldaptive.LdapException;
import org.ldaptive.SearchScope;
import org.ldaptive.templates.SearchTemplates;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;

import com.foodauthent.api.internal.people.PersonService;

@Component(service = { LdapPersonService.class, PersonService.class }, scope = ServiceScope.SINGLETON)
public class LdapPersonServiceImpl extends AbstractLdapEntryService<LdapPerson> implements LdapPersonService {

	private static final String OBJECT_CLASS_FILTER = "(&(objectClass=inetOrgPerson)(objectClass=organizationalPerson)(objectClass=person))";

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private LDAPConfig config;

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private LdapOperationManager ldapOperationManager;

	private static final SearchTemplates oneTermTemplate = new SearchTemplates( //
			createFilters(OBJECT_CLASS_FILTER, //
					"(|(givenName={term1})(sn={term1}))", //
					"(|(givenName={term1}*)(sn={term1}*))", //
					"(|(givenName=*{term1}*)(sn=*{term1}*))", //
					"(|(telephoneNumber={term1})(localPhone={term1}))", //
					"(|(telephoneNumber=*{term1})(localPhone=*{term1}))"));

	private static final SearchTemplates twoTermTemplate = new SearchTemplates( //
			createFilters(OBJECT_CLASS_FILTER, //
					"(&(givenName={term1})(sn={term2}))", //
					"(cn={term1} {term2})", //
					"(&(givenName={term1}*)(sn={term2}*))", //
					"(cn={term1}* {term2}*)", "(&(givenName=*{term1}*)(sn=*{term2}*))", //
					"(cn=*{term1}* *{term2}*)"));

	private static final SearchTemplates threeTermTemplate = new SearchTemplates( //
			createFilters(OBJECT_CLASS_FILTER, //
					"(|(&(givenName={term1})(sn={term3}))(&(givenName={term2})(sn={term3})))", //
					"(|(cn={term1} {term2} {term3})(cn={term2} {term1} {term3}))", //
					"(|(&(givenName={term1}*)(sn={term3}*))(&(givenName={term2}*)(sn={term3}*)))", //
					"(|(cn={term1}* {term2}* {term3}*)(cn={term2}* {term1}* {term3}*))", //
					"(|(&(givenName=*{term1}*)(sn=*{term3}*))(&(givenName=*{term2}*)(sn=*{term3}*)))", //
					"(|(cn=*{term1}* *{term2}* *{term3}*)(cn=*{term2}* *{term1}* *{term3}*))", //
					"(|(&(givenName={term1})(middleName={initial2}*)(sn={term3}))(&(givenName={term2})(middleName={initial1}*)(sn={term3})))", //
					"(|(&(givenName={initial1}*)(middlename={initial2}*)(sn={term3}))(&(givenName={initial2}*)(middleName={initial1}*)(sn={term3})))", //
					"(sn={term3})"));

	public LdapPersonServiceImpl() {
		super(LdapPerson.class, oneTermTemplate, twoTermTemplate, threeTermTemplate);
	}

	@Activate
	public void activate() {
		super.initialize(ldapOperationManager, config);
	}

	@Override
	protected void validate(LdapPerson v, boolean mustExist) throws ServiceException {
		super.validate(v, mustExist);
		if (v.getUserName() == null) {
			throw new InvalidOperationException("userName must not be null");
		}
		if (!mustExist) {
			final String existsFilter = "(&" + OBJECT_CLASS_FILTER + "(uid=" + v.getUserName() + "))";
			try {
				Set<String> existingDns = ldapService
						.search(config.getBaseDn(), existsFilter, SearchScope.SUBTREE, "dn").getEntries().stream()
						.map(n -> {
							return n.getDn();
						}).collect(Collectors.toSet());
				if (!existingDns.isEmpty()) {
					throw new EntityAlreadyExistsException(String.format("userName %s is already in use by %s",
							v.getUserName(), String.join(", ", existingDns.toArray(new String[0]))));
				}
			} catch (LdapException e) {
				throw new ServiceException(e.getMessage());
			}
		}
	}

	@Override
	public LdapPerson newEntryInstance(String identifier) {
		final LdapPerson instance = super.newEntryInstance();
		instance.setDn(identifier);
		return instance;
	}

}
