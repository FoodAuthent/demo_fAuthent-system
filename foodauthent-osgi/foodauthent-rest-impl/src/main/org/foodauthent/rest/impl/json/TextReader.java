package org.foodauthent.rest.impl.json;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import org.apache.commons.io.IOUtils;

public class TextReader implements MessageBodyReader<Object>, Feature {

	@Override
	public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
		return arg3.isCompatible(MediaType.TEXT_PLAIN_TYPE) || arg3.isCompatible(MediaType.TEXT_HTML_TYPE)
				|| arg3.isCompatible(MediaType.TEXT_XML_TYPE);
	}

	@Override
	public Object readFrom(final Class<Object> type, final Type genericType, final Annotation[] annotations,
			final MediaType mediaType, final MultivaluedMap<String, String> httpHeaders, final InputStream entityStream)
			throws IOException, WebApplicationException {
		return IOUtils.toString(entityStream, StandardCharsets.UTF_8);
	}

	@Override
	public boolean configure(FeatureContext context) {
		return true;
	}
}
