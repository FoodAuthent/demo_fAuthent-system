package org.foodauthent.epcis.ftrace.config;

import org.foodauthent.config.ConfigObjectRegistration;
import org.foodauthent.config.ConfigurationListener;
import org.osgi.service.component.annotations.Component;

@Component(service = ConfigurationListener.class, immediate = true)
public class FTraceConfigRegistration extends ConfigObjectRegistration<FTraceConfig> {

	public FTraceConfigRegistration() {
		super(FTraceConfig.class, "epcis.ftrace");
	}

}
