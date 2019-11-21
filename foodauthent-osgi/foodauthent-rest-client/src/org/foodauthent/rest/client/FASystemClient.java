package org.foodauthent.rest.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedHashMap;

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
	this(host + ":" + port);
    }

    private WebTarget newWebTarget(String url) {
	Client client = ClientBuilder.newClient().register(JacksonJSONWriter.class, Integer.MAX_VALUE)
		.register(JacksonJSONReader.class, Integer.MAX_VALUE).register(MultiPartFeature.class)
		.register(TextReader.class);
	return client.target(url);
    }

    @SuppressWarnings("unchecked")
    <S> S createClientProxy(Class<S> serviceClass) {
	final MultivaluedHashMap<String, Object> headers = new MultivaluedHashMap<String, Object>();
//	headers.put("Authorization", Arrays.asList(
//		"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmdhbml6YXRpb25OYW1lIjoiQmZSX3Rlc3QiLCJ1c2VySWRlbnRpZmllciI6InVpZD10aG9tYXMuc2NodWVsZXJAZm9vZGF1dGhlbnQubmV0LG91PXVzZXJzLG91PUJmUl90ZXN0LGRjPWZvb2RhdXRoZW50LGRjPW9yZyIsIm9yZ2FuaXphdGlvbklkZW50aWZpZXIiOiJvdT1CZlJfdGVzdCxkYz1mb29kYXV0aGVudCxkYz1vcmciLCJpc3MiOiJmb29kYXV0aGVudC1hcGkiLCJncm91cHMiOltdLCJ1c2VyTmFtZSI6InRob21hcy5zY2h1ZWxlckBmb29kYXV0aGVudC5uZXQiLCJleHAiOjE1NzM3NTQxOTh9.MXS1K_MgtpLF5pab1lwtYEuJhIbRUg2StWLdzRngvAw"));
	return (S) clientProxyCache.computeIfAbsent(serviceClass, c -> WebResourceFactory.newResource(serviceClass,
		webTarget, false, headers, Collections.<Cookie>emptyList(), new Form()));
    }

    WebTarget getWebTarget() {
	return webTarget;
    }
}
