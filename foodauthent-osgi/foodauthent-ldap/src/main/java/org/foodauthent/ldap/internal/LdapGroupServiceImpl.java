package org.foodauthent.ldap.internal;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.ldap.DnUtil;
import org.foodauthent.ldap.LdapGroupService;
import org.foodauthent.ldap.LdapOperationManager;
import org.foodauthent.ldap.beans.LdapGroup;
import org.foodauthent.ldap.config.LDAPConfig;
import org.ldaptive.LdapException;
import org.ldaptive.SearchScope;
import org.ldaptive.templates.SearchTemplates;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;

import com.foodauthent.api.internal.people.GroupService;

@Component(service = { LdapGroupService.class, GroupService.class }, scope = ServiceScope.SINGLETON)
public class LdapGroupServiceImpl extends AbstractLdapEntryService<LdapGroup> implements LdapGroupService {

	private static final String OBJECT_CLASS_FILTER = "(objectClass=groupOfUniqueNames)";

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private LDAPConfig config;

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private LdapOperationManager ldapOperationManager;

	public LdapGroupServiceImpl() {
		super(LdapGroup.class, new SearchTemplates( //
				createFilters(OBJECT_CLASS_FILTER, //
						"(|(cn={term1})(description={term1}))", //
						"(|(cn={term1}*)(description={term1}*))", //
						"(|(cn=*{term1}*)(description=*{term1}*))")));
	}

	@Activate
	public void activate() {
		super.initialize(ldapOperationManager, config);
		searchExecutor.getSearchExecutor().setBaseDn(config.getGroupDn());
	}

	@Override
	protected void validate(LdapGroup v, boolean mustExist) throws ServiceException {
		super.validate(v, mustExist);
		if (StringUtils.isEmpty(v.getName())) {
			throw new InvalidOperationException("commonName must not be null");
		}
		if (v.getGroupMembers() == null || v.getGroupMembers().isEmpty()) {
			throw new InvalidOperationException("uniqueMember must not be empty");
		}
		if (!mustExist) {
			final String existsFilter = "(cn=" + v.getName() + ")";
			try {
				Set<String> existingDns = ldapService
						.search(config.getGroupDn(), existsFilter, SearchScope.ONELEVEL, "dn").getEntries().stream()
						.map(n -> {
							return n.getDn();
						}).collect(Collectors.toSet());
				if (!existingDns.isEmpty()) {
					throw new EntityAlreadyExistsException(String.format("commonName %s is already in use by group %s",
							v.getName(), String.join(", ", existingDns.toArray(new String[0]))));
				}
			} catch (LdapException e) {
				throw new ServiceException(e.getMessage());
			}
		}
	}

	/**
	 * list of LdapGroups the given user's dn is member of
	 * 
	 * @param userDn
	 * @return
	 * @throws ServiceException
	 */
	public List<LdapGroup> getUserGroups(final String userDn) throws ServiceException {
		try {
			return ldapService
					.search(config.getGroupDn(), "(&" + OBJECT_CLASS_FILTER + "(uniqueMember=" + userDn + "))",
							SearchScope.ONELEVEL, getReturnAttributes())
					.getEntries().stream().map(e -> {
						final LdapGroup g = map(e);
						return g;
					}).collect(Collectors.toList());
		} catch (LdapException e) {
			throw new ServiceException(String.format("unable to get list of groups for dn %s", userDn), e);
		}
	}

	/**
	 * list all available groups
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<LdapGroup> list() throws ServiceException {
		try {
			return ldapService
					.search(config.getGroupDn(), OBJECT_CLASS_FILTER, SearchScope.ONELEVEL, getReturnAttributes())
					.getEntries().stream().map(e -> {
						final LdapGroup g = map(e);
						return g;
					}).collect(Collectors.toList());
		} catch (LdapException e) {
			throw new ServiceException("unable to list groups", e);
		}
	}

	@Override
	public LdapGroup add(LdapGroup ldapGroup) throws EntityAlreadyExistsException, ServiceException {
		ldapGroup.setDn(DnUtil.buildDn(config.getGroupDn(), "cn", ldapGroup.getName()));
		return super.add(ldapGroup);
	}

	@Override
	public LdapGroup newEntryInstance(String identifier) {
		final LdapGroup instance = super.newEntryInstance();
		instance.setDescription(identifier);
		return instance;
	}

}
