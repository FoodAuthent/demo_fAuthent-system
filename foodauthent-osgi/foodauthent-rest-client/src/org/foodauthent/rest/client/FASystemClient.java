package org.foodauthent.rest.client;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.foodauthent.rest.impl.json.JacksonJSONReader;
import org.foodauthent.rest.impl.json.JacksonJSONWriter;
import org.foodauthent.rest.impl.json.TextReader;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

/**
 * 
 * @author Martin Horn, University of Konstanz
 */
public class FASystemClient {

    private final WebTarget webTarget;

    private final Map<Class<?>, Object> clientProxyCache = new HashMap<>();

    public FASystemClient(String url) {
	webTarget = newWebTarget(url);
    }

    public FASystemClient(String host, int port) {
	this("http://" + host + ":" + port);
    }

    private WebTarget newWebTarget(String url) {
	Client client = ClientBuilder.newClient().register(JacksonJSONWriter.class, Integer.MAX_VALUE)
		.register(JacksonJSONReader.class, Integer.MAX_VALUE).register(MultiPartFeature.class)
		.register(TextReader.class);
	return client.target(url);
    }

    @SuppressWarnings("unchecked")
    <S> S createClientProxy(Class<S> serviceClass) {
	return (S) clientProxyCache.computeIfAbsent(serviceClass,
		c -> WebResourceFactory.newResource(serviceClass, webTarget));
    }

    WebTarget getWebTarget() {
	return webTarget;
    }
}
