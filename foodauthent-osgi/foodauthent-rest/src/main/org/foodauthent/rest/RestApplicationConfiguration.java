package org.foodauthent.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.foodauthent.rest.json.JacksonJSONReader;
import org.foodauthent.rest.json.JacksonJSONWriter;
import org.glassfish.jersey.server.ServerProperties;

import com.eclipsesource.jaxrs.publisher.ApplicationConfiguration;

public class RestApplicationConfiguration implements ApplicationConfiguration {

	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		// don't look for implementations described by META-INF/services/*
		properties.put(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, false);
		// disable auto discovery on server, as it's handled via OSGI
		properties.put(ServerProperties.FEATURE_AUTO_DISCOVERY_DISABLE, true);
		// Tells the Jersey Servlet which REST service/class to load
		properties.put(ServerProperties.PROVIDER_CLASSNAMES, getProviderClassNames());
		// Makes sure that the writer is used by somehow changing the order of providers
		properties.put("jersey.config.workers.legacyOrdering", true);
		return properties;
	}
	
    static List<Class<?>> getProviderClasses() {
        List<Class<?>> providers = new ArrayList<Class<?>>();
        providers.add(JacksonJSONReader.class);
        providers.add(JacksonJSONWriter.class);
        return providers;
    }
    
    static String getProviderClassNames() {
        return getProviderClasses().stream().map(c -> c.getCanonicalName()).collect(Collectors.joining(","));
    }

}
