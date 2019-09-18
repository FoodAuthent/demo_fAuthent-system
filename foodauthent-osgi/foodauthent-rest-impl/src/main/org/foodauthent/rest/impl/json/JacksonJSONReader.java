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
import org.foodauthent.model.json.ObjectMapperUtil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JacksonJSONReader implements MessageBodyReader<Object>, Feature {

	private final ObjectMapper mapper = ObjectMapperUtil.getObjectMapper().registerModule(new JavaTimeModule()).
			enable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

	@Override
	public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
		return arg3.isCompatible(MediaType.APPLICATION_JSON_TYPE);
	}

	@Override
	public Object readFrom(final Class<Object> type, final Type genericType, final Annotation[] annotations,
			final MediaType mediaType, final MultivaluedMap<String, String> httpHeaders, final InputStream entityStream)
			throws IOException, WebApplicationException {
		// TODO: please improve
		// return string type without any parsing
		if (String.class.isAssignableFrom(type)) {
			return IOUtils.toString(entityStream, StandardCharsets.UTF_8);
		}
		ObjectReader reader = mapper.readerFor(type);
		JsonParser jp = reader.getFactory().createParser(entityStream);
		final Object o = reader.readValue(jp);
		return o;
	}

	@Override
	public boolean configure(FeatureContext context) {
		return true;
	}
}
