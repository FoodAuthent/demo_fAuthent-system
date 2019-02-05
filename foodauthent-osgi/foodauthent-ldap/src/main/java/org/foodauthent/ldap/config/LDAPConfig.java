package org.foodauthent.ldap.config;

import java.time.Duration;
import java.util.List;

import org.foodauthent.config.ConfigObject;
import org.ldaptive.BindConnectionInitializer;
import org.ldaptive.ConnectionConfig;
import org.ldaptive.Credential;
import org.ldaptive.RoundRobinConnectionStrategy;
import org.ldaptive.pool.PoolConfig;

public class LDAPConfig implements ConfigObject {

	private static final long serialVersionUID = 1L;

	private List<String> urls;

	private boolean ssl = false;

	private boolean tls = false;

	private int connectionTimeout = 10;

	private int responseTimeout = 60;

	private String bindDn = null;

	private String bindPassword = null;

	private String baseDn = null;

	private String groupDn = null;

	private int maxPoolSize = 10;

	private int minPoolSize = 3;

	private boolean validateOnCheckIn = false;

	private boolean validateOnCheckOut = false;

	private int validatePeriod = 180;

	private boolean validatePeriodically = false;

	private int validateTimeout = 5;

	private Integer blockWaitTime = null;

	private boolean blocking = true;

	private String userFilter = "(&(objectClass=inetOrgPerson)(uid={user}))";

	public ConnectionConfig connectionConfig() {
		final ConnectionConfig config = new ConnectionConfig();
		config.setLdapUrl(String.join(" ", urls));
		if (urls.size() > 1) {
			config.setConnectionStrategy(new RoundRobinConnectionStrategy());
		}
		if (bindDn != null && bindPassword != null) {
			config.setConnectionInitializer(new BindConnectionInitializer(bindDn, new Credential(bindPassword)));
		}
		config.setUseSSL(ssl);
		config.setUseStartTLS(tls);
		config.setConnectTimeout(Duration.ofSeconds(connectionTimeout));
		config.setResponseTimeout(Duration.ofSeconds(responseTimeout));
		return config;
	}

	public PoolConfig poolConfig() {
		final PoolConfig config = new PoolConfig();
		config.setMaxPoolSize(maxPoolSize);
		config.setMinPoolSize(minPoolSize);
		config.setValidateOnCheckIn(validateOnCheckIn);
		config.setValidateOnCheckOut(validateOnCheckOut);
		config.setValidatePeriodically(validatePeriodically);
		config.setValidatePeriod(Duration.ofSeconds(validatePeriod));
		config.setValidateTimeout(Duration.ofSeconds(validateTimeout));
		return config;
	}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public boolean isTls() {
		return tls;
	}

	public void setTls(boolean tls) {
		this.tls = tls;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getResponseTimeout() {
		return responseTimeout;
	}

	public void setResponseTimeout(int responseTimeout) {
		this.responseTimeout = responseTimeout;
	}

	public String getBindDn() {
		return bindDn;
	}

	public void setBindDn(String bindDn) {
		this.bindDn = bindDn;
	}

	public String getBindPassword() {
		return bindPassword;
	}

	public void setBindPassword(String bindPassword) {
		this.bindPassword = bindPassword;
	}

	public String getBaseDn() {
		return baseDn;
	}

	public void setBaseDn(String baseDn) {
		this.baseDn = baseDn;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public int getMinPoolSize() {
		return minPoolSize;
	}

	public void setMinPoolSize(int minPoolSize) {
		this.minPoolSize = minPoolSize;
	}

	public boolean isValidateOnCheckIn() {
		return validateOnCheckIn;
	}

	public void setValidateOnCheckIn(boolean validateOnCheckIn) {
		this.validateOnCheckIn = validateOnCheckIn;
	}

	public boolean isValidateOnCheckOut() {
		return validateOnCheckOut;
	}

	public void setValidateOnCheckOut(boolean validateOnCheckOut) {
		this.validateOnCheckOut = validateOnCheckOut;
	}

	public int getValidatePeriod() {
		return validatePeriod;
	}

	public void setValidatePeriod(int validatePeriod) {
		this.validatePeriod = validatePeriod;
	}

	public boolean isValidatePeriodically() {
		return validatePeriodically;
	}

	public void setValidatePeriodically(boolean validatePeriodically) {
		this.validatePeriodically = validatePeriodically;
	}

	public int getValidateTimeout() {
		return validateTimeout;
	}

	public void setValidateTimeout(int validateTimeout) {
		this.validateTimeout = validateTimeout;
	}

	public Integer getBlockWaitTime() {
		return blockWaitTime;
	}

	public void setBlockWaitTime(Integer blockWaitTime) {
		this.blockWaitTime = blockWaitTime;
	}

	public boolean isBlocking() {
		return blocking;
	}

	public void setBlocking(boolean blocking) {
		this.blocking = blocking;
	}

	public String getUserFilter() {
		return userFilter;
	}

	public void setUserFilter(String userFilter) {
		this.userFilter = userFilter;
	}

	public String getGroupDn() {
		return groupDn;
	}

	public void setGroupDn(String groupDn) {
		this.groupDn = groupDn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseDn == null) ? 0 : baseDn.hashCode());
		result = prime * result + ((bindDn == null) ? 0 : bindDn.hashCode());
		result = prime * result + ((blockWaitTime == null) ? 0 : blockWaitTime.hashCode());
		result = prime * result + (blocking ? 1231 : 1237);
		result = prime * result + connectionTimeout;
		result = prime * result + ((groupDn == null) ? 0 : groupDn.hashCode());
		result = prime * result + maxPoolSize;
		result = prime * result + minPoolSize;
		result = prime * result + ((bindPassword == null) ? 0 : bindPassword.hashCode());
		result = prime * result + responseTimeout;
		result = prime * result + (ssl ? 1231 : 1237);
		result = prime * result + (tls ? 1231 : 1237);
		result = prime * result + ((urls == null) ? 0 : urls.hashCode());
		result = prime * result + ((userFilter == null) ? 0 : userFilter.hashCode());
		result = prime * result + (validateOnCheckIn ? 1231 : 1237);
		result = prime * result + (validateOnCheckOut ? 1231 : 1237);
		result = prime * result + validatePeriod;
		result = prime * result + (validatePeriodically ? 1231 : 1237);
		result = prime * result + validateTimeout;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LDAPConfig other = (LDAPConfig) obj;
		if (baseDn == null) {
			if (other.baseDn != null)
				return false;
		} else if (!baseDn.equals(other.baseDn))
			return false;
		if (bindDn == null) {
			if (other.bindDn != null)
				return false;
		} else if (!bindDn.equals(other.bindDn))
			return false;
		if (blockWaitTime == null) {
			if (other.blockWaitTime != null)
				return false;
		} else if (!blockWaitTime.equals(other.blockWaitTime))
			return false;
		if (blocking != other.blocking)
			return false;
		if (connectionTimeout != other.connectionTimeout)
			return false;
		if (groupDn == null) {
			if (other.groupDn != null)
				return false;
		} else if (!groupDn.equals(other.groupDn))
			return false;
		if (maxPoolSize != other.maxPoolSize)
			return false;
		if (minPoolSize != other.minPoolSize)
			return false;
		if (bindPassword == null) {
			if (other.bindPassword != null)
				return false;
		} else if (!bindPassword.equals(other.bindPassword))
			return false;
		if (responseTimeout != other.responseTimeout)
			return false;
		if (ssl != other.ssl)
			return false;
		if (tls != other.tls)
			return false;
		if (urls == null) {
			if (other.urls != null)
				return false;
		} else if (!urls.equals(other.urls))
			return false;
		if (userFilter == null) {
			if (other.userFilter != null)
				return false;
		} else if (!userFilter.equals(other.userFilter))
			return false;
		if (validateOnCheckIn != other.validateOnCheckIn)
			return false;
		if (validateOnCheckOut != other.validateOnCheckOut)
			return false;
		if (validatePeriod != other.validatePeriod)
			return false;
		if (validatePeriodically != other.validatePeriodically)
			return false;
		if (validateTimeout != other.validateTimeout)
			return false;
		return true;
	}

}
