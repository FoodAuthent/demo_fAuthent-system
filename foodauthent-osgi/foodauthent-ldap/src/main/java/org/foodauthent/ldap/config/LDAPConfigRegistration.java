package org.foodauthent.ldap.config;

import org.foodauthent.config.ConfigObjectRegistration;
import org.foodauthent.config.ConfigurationListener;
import org.osgi.service.component.annotations.Component;

@Component(service = ConfigurationListener.class, immediate = true)
public class LDAPConfigRegistration extends ConfigObjectRegistration<LDAPConfig> {

	public LDAPConfigRegistration() {
		super(LDAPConfig.class, "ldap");
	}

}
