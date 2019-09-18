package org.foodauthent.rest.impl.json;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import org.apache.commons.io.IOUtils;
import org.foodauthent.model.json.ObjectMapperUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JacksonJSONWriter implements MessageBodyWriter<Object>, Feature {
	private final ObjectMapper mapper = ObjectMapperUtil.getObjectMapper().registerModule(new JavaTimeModule());;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long getSize(final Object value, final Class<?> type, final Type genericType, final Annotation[] annotations,
			final MediaType mediaType) {
		return -1; // no idea how many byte we will write
	}

	@Override
	public boolean isWriteable(final Class<?> type, final Type genericType, final Annotation[] annotations,
			final MediaType mediaType) {
		return mediaType.isCompatible(MediaType.APPLICATION_JSON_TYPE);
	}

	@Override
	public void writeTo(final Object value, final Class<?> type, final Type genericType, final Annotation[] annotations,
			final MediaType mediaType, final MultivaluedMap<java.lang.String, java.lang.Object> httpHeaders,
			final OutputStream entityStream) throws JsonGenerationException, JsonMappingException, IOException {
		if (String.class.isAssignableFrom(type)) {
			IOUtils.write((String) value, entityStream, StandardCharsets.UTF_8);
		} else {
			mapper.writeValue(entityStream, value);
		}
	}

	@Override
	public boolean configure(FeatureContext context) {
		return true;
	}
}
