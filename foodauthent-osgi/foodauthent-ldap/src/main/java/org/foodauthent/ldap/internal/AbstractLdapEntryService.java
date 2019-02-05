package org.foodauthent.ldap.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.foodauthent.common.exception.EntityAlreadyExistsException;
import org.foodauthent.common.exception.EntityNotFoundException;
import org.foodauthent.common.exception.InvalidOperationException;
import org.foodauthent.common.exception.ServiceException;
import org.foodauthent.ldap.LdapEntryService;
import org.foodauthent.ldap.LdapOperationManager;
import org.foodauthent.ldap.beans.Dn;
import org.foodauthent.ldap.config.LDAPConfig;
import org.ldaptive.Connection;
import org.ldaptive.LdapEntry;
import org.ldaptive.LdapException;
import org.ldaptive.ModifyDnOperation;
import org.ldaptive.ModifyDnRequest;
import org.ldaptive.Response;
import org.ldaptive.ResultCode;
import org.ldaptive.SearchResult;
import org.ldaptive.SearchScope;
import org.ldaptive.beans.persistence.DefaultLdapEntryManager;
import org.ldaptive.beans.reflect.DefaultLdapEntryMapper;
import org.ldaptive.concurrent.AggregatePooledSearchExecutor;
import org.ldaptive.pool.PooledConnectionFactory;
import org.ldaptive.templates.Query;
import org.ldaptive.templates.SearchTemplates;
import org.ldaptive.templates.SearchTemplatesExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class AbstractLdapEntryService<T extends Dn> implements LdapEntryService<T> {

	private Logger LOGGER = LoggerFactory.getLogger(AbstractLdapEntryService.class);

	protected DefaultLdapEntryManager<T> manager;

	protected DefaultLdapEntryMapper<T> mapper = new DefaultLdapEntryMapper<T>();

	protected SearchTemplatesExecutor searchExecutor;

	protected LdapOperationManager ldapService;

	protected AggregatePooledSearchExecutor pooledSearchExecutor;

	protected Class<T> cls;

	protected String objectClassFilter;

	protected SearchTemplates[] searchTemplates;

	AbstractLdapEntryService(@NotNull final Class<T> cls, SearchTemplates... searchTemplates) {
		this.cls = cls;
		this.searchTemplates = searchTemplates;
	}

	protected void initialize(final LdapOperationManager ldapService, final LDAPConfig config) {
		this.ldapService = ldapService;
		manager = new DefaultLdapEntryManager<T>(mapper, ldapService.getConnectionFactory());
		pooledSearchExecutor = new AggregatePooledSearchExecutor();
		pooledSearchExecutor.setReturnAttributes(getReturnAttributes());
		pooledSearchExecutor.setBaseDn(config.getBaseDn());
		searchExecutor = new SearchTemplatesExecutor(pooledSearchExecutor,
				new PooledConnectionFactory[] { ldapService.getConnectionFactory() }, searchTemplates);
	}

	protected void unbindLDAPConfig(final LDAPConfig config) {
		ldapService = null;
		manager = null;
		pooledSearchExecutor = null;
		searchExecutor = null;
	}

	public T newEntryInstance() {
		try {
			final T instance = cls.getConstructor().newInstance();
			return instance;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(cls.getName() + " must have a public empty constructor", e);
		}
	}

	public T add(T v) throws EntityAlreadyExistsException, ServiceException {
		validate(v, false);
		try {
			final Response<Void> r = manager.add(v);
			handleRespone(r);
		} catch (LdapException e) {
			throw new ServiceException(String.format("LdapException: delete(%s)", v.toString()), e);
		}
		return get(v.getDn());
	}

	public void deleteRecursive(T v) throws EntityNotFoundException, InvalidOperationException, ServiceException {
		validate(v, true);
		try {
			final Set<String> del = ldapService.search(v.getDn(), "(objectClass=*)", SearchScope.ONELEVEL, "dn")
					.getEntries().stream().filter(e -> !e.getDn().equals(v.getDn())).map(e -> e.getDn())
					.collect(Collectors.toSet());
			for (String d : del) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(String.format("deleting child %s", d));
				}
				ldapService.delete(d);
			}
			final Response<Void> r = manager.delete(v);
			handleRespone(r);
		} catch (LdapException e) {
			throw new ServiceException(String.format("LdapException: delete(%s)", v.toString()), e);
		}
	}

	public void delete(T v) throws EntityNotFoundException, InvalidOperationException, ServiceException {
		validate(v, true);
		try {
			final Response<Void> r = manager.delete(v);
			handleRespone(r);
		} catch (LdapException e) {
			throw new ServiceException(String.format("LdapException: delete(%s)", v.toString()), e);
		}
	}

	public T update(T v) throws EntityNotFoundException, ServiceException {
		validate(v, true);
		try {
			final String updatedDn = v.updateDn();
			if (!updatedDn.equals(v.getDn())) {
				Connection conn = ldapService.getConnection();
				try {
					final ModifyDnOperation modifyDnOperation = new ModifyDnOperation(conn);
					final ModifyDnRequest modifyDnRequest = new ModifyDnRequest(v.getDn(), updatedDn);
					final Response<Void> r = modifyDnOperation.execute(modifyDnRequest);
					handleRespone(r);
					v.setDn(updatedDn);
				} finally {
					conn.close();
				}
			}
			final Response<Void> r = manager.merge(v);
			handleRespone(r);
			return get(v.getDn());
		} catch (LdapException e) {
			throw new ServiceException(String.format("LdapException: merge(%s)", v.toString()), e);
		}
	}

	public T get(final String dn) throws EntityNotFoundException, ServiceException {
		if (dn == null) {
			throw new ServiceException("dn must not be null");
		}
		final T f = newEntryInstance();
		f.setDn(dn);
		try {
			final T r = manager.find(f);
			if (r == null) {
				throw new EntityNotFoundException(dn + " not found");
			}
			return r;
		} catch (LdapException e) {
			throw new ServiceException(String.format("LdapException: get(%s)", dn), e);
		} catch (IllegalArgumentException e) {
			throw new EntityNotFoundException(String.format("LdapException: get(%s)", dn), e);
		}
	}

	public T map(final LdapEntry entry) {
		final T m = newEntryInstance();
		mapper.map(entry, m);
		return m;
	}

	public String[] getReturnAttributes() {
		return manager.getReturnAttributes();
	}

	public Collection<T> search(String s) {
		final Query query = new Query(s);
		try {
			final SearchResult result = searchExecutor.search(query);
			return result.getEntries().stream().map(e -> {
				final T p = map(e);
				return p;
			}).collect(Collectors.toList());
		} catch (LdapException e) {
			LOGGER.error("unable to perform search for \"%s\"", s);
		}
		return Collections.emptyList();
	}

	protected static final String[] createFilters(final String objectClassFilter, final String... filter) {
		final List<String> filters = new ArrayList<String>();
		for (String f : filter) {
			filters.add("(&".concat(objectClassFilter).concat(f).concat(")"));
		}
		return filters.toArray(new String[0]);
	}

	protected void validate(T v, boolean mustExist) throws ServiceException {
		if (v.getDn() == null) {
			throw new ServiceException("dn must not be null");
		}
		// check exists based on dn
		final boolean entryExists = ldapService.entryExists(v.getDn());
		if (mustExist && !entryExists) {
			throw new EntityNotFoundException(String.format("%s not found", v.getDn()));
		}
		if (!mustExist && entryExists) {
			throw new EntityAlreadyExistsException(String.format("%s already exists", v.getDn()));
		}
	}

	private void handleRespone(final Response<Void> r) throws ServiceException {
		final ResultCode c = r.getResultCode();
		if (c != null) {
			switch (c) {
			case SUCCESS:
				break;
			case ENTRY_ALREADY_EXISTS:
				throw new EntityAlreadyExistsException(c.name());
			case NO_SUCH_OBJECT:
				throw new EntityNotFoundException(c.name());
			case NOT_ALLOWED_ON_NONLEAF:
				throw new InvalidOperationException(c.name() + ": " + c.name());
			default:
				throw new ServiceException(c.name() + ": " + r.getMessage());
			}
		}

	}

	public Class<T> getEntryClass() {
		return cls;
	}

}
