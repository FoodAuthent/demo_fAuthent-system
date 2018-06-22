package org.foodauthent.rest.json;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import org.foodauthent.model.json.ObjectMapperUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CollectionJSONWriter implements MessageBodyWriter<Collection<?>>, Feature {
	private final ObjectMapper mapper = ObjectMapperUtil.getObjectMapper();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long getSize(final Collection<?> value, final Class<?> type, final Type genericType,
			final Annotation[] annotations, final MediaType mediaType) {
		return -1; // no idea how many byte we will write
	}

	@Override
	public boolean isWriteable(final Class<?> type, final Type genericType, final Annotation[] annotations,
			final MediaType mediaType) {
		return Collection.class.isAssignableFrom(type);
	}

	@Override
	public void writeTo(final Collection<?> value, final Class<?> type, final Type genericType,
			final Annotation[] annotations, final MediaType mediaType,
			final MultivaluedMap<java.lang.String, java.lang.Object> httpHeaders, final OutputStream entityStream)
			throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writeValue(entityStream, value);
	}

	@Override
	public boolean configure(FeatureContext context) {
		return true;
	}
}
