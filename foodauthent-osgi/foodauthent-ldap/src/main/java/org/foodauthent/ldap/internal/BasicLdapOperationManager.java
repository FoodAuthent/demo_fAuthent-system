package org.foodauthent.ldap.internal;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.foodauthent.ldap.LdapOperationManager;
import org.foodauthent.ldap.config.LDAPConfig;
import org.ldaptive.Connection;
import org.ldaptive.DefaultConnectionFactory;
import org.ldaptive.DeleteOperation;
import org.ldaptive.DeleteRequest;
import org.ldaptive.LdapEntry;
import org.ldaptive.LdapException;
import org.ldaptive.Response;
import org.ldaptive.ResultCode;
import org.ldaptive.SearchExecutor;
import org.ldaptive.SearchResult;
import org.ldaptive.SearchScope;
import org.ldaptive.pool.BlockingConnectionPool;
import org.ldaptive.pool.PooledConnectionFactory;
import org.ldaptive.pool.SoftLimitConnectionPool;
import org.ldaptive.provider.apache.ApacheLdapProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = { LdapOperationManager.class }, scope = ServiceScope.SINGLETON, immediate = true)
public class BasicLdapOperationManager implements LdapOperationManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasicLdapOperationManager.class);

	private PooledConnectionFactory pooledConnectionFactory;

	private LDAPConfig config;

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	public void bindLDAPConfig(final LDAPConfig config) {
		this.config = config;
		if (pooledConnectionFactory != null) {
			deactivate();
			activate();
		}
	}

	@Activate
	public void activate() {
		PooledConnectionFactory pooledConnectionFactory;
		final DefaultConnectionFactory cf = new DefaultConnectionFactory(config.connectionConfig(),
				new ApacheLdapProvider());
		if (config.isBlocking()) {
			final BlockingConnectionPool bcp = new BlockingConnectionPool(config.poolConfig(), cf);
			if (config.getBlockWaitTime() != null) {
				bcp.setBlockWaitTime(Duration.ofSeconds(config.getBlockWaitTime()));
			}
			pooledConnectionFactory = new PooledConnectionFactory(bcp);
		} else {
			pooledConnectionFactory = new PooledConnectionFactory(new SoftLimitConnectionPool(config.poolConfig(), cf));
		}
		pooledConnectionFactory.getConnectionPool().initialize();
		// switch connection factory
		if (this.pooledConnectionFactory != null) {
			this.pooledConnectionFactory.getConnectionPool().close();
		}
		this.pooledConnectionFactory = pooledConnectionFactory;
	}

	@Deactivate
	public void deactivate() {
		if (pooledConnectionFactory != null) {
			pooledConnectionFactory.getConnectionPool().close();
			pooledConnectionFactory = null;
		}
	}

	@Override
	public Connection getConnection() throws LdapException {
		return pooledConnectionFactory.getConnection();
	}

	@Override
	public PooledConnectionFactory getConnectionFactory() {
		return pooledConnectionFactory;
	}

	@Override
	public SearchResult search(final String dn, final String filter, final SearchScope scope,
			final String... returnAttributes) throws LdapException {
		final SearchExecutor exec = new SearchExecutor();
		exec.setBaseDn(dn);
		exec.setSearchScope(scope);
		if (returnAttributes != null) {
			exec.setReturnAttributes(returnAttributes);
		}
		return exec.search(pooledConnectionFactory, filter).getResult();
	}

	@Override
	public boolean entryExists(final String dn) {
		return getEntry(dn, "dn").isPresent();
	}

	@Override
	public Optional<LdapEntry> getEntry(final String dn, final String... returnAttributes) {
		try {
			final SearchResult result = search(dn, "(objectClass=*)", SearchScope.OBJECT, returnAttributes);
			return Optional.ofNullable(result.getEntry());
		} catch (Exception e) {
			LOGGER.error(String.format("unable to get entry for dn %s", dn), e);
			return Optional.empty();
		}
	}

	/**
	 * Recursively deletes DN
	 * 
	 * @param dn
	 *            delete this DN tree from LDAP
	 */
	@Override
	public void delete(final String dn) throws LdapException {
		List<String> del = search(dn, "(objectClass=*)", SearchScope.ONELEVEL, "dn").getEntries().stream()
				.filter(e -> !e.getDn().equals(dn)).map(e -> e.getDn()).collect(Collectors.toList());
		for (String d : del) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(String.format("deleting child %s", d));
			}
			delete(d);
		}
		Connection conn = getConnection();
		try {
			final DeleteOperation deleteOperation = new DeleteOperation(conn);
			final DeleteRequest deleteRequest = new DeleteRequest(dn);
			final Response<Void> r = deleteOperation.execute(deleteRequest);
			if (r.getResultCode() != ResultCode.SUCCESS) {
				throw new LdapException(String.format("unable to delete dn %s: %s", dn, r.getMessage()));
			}
		} finally {
			conn.close();
		}

	}

}
