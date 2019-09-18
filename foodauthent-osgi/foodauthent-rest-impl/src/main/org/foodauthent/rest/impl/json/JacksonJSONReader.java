package org.foodauthent.rest.impl.json;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

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

	private final ObjectMapper mapper = ObjectMapperUtil.getObjectMapper() //
			.registerModule(new JavaTimeModule()). //
			enable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

	@Override
	public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
		return arg3.isCompatible(MediaType.APPLICATION_JSON_TYPE);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object readFrom(final Class<Object> type, final Type genericType, final Annotation[] annotations,
			final MediaType mediaType, final MultivaluedMap<String, String> httpHeaders, final InputStream entityStream)
			throws IOException, WebApplicationException {

		// TODO:
		// if someone's really having time: use to strategy pattern ;-)
		
		ObjectReader reader = null;
		if (ParameterizedType.class.isAssignableFrom(genericType.getClass()) //
				&& ((ParameterizedType) genericType).getActualTypeArguments().length == 1 //
				&& Collection.class.isAssignableFrom(type)) {
			try {

				reader = mapper.readerFor(mapper.getTypeFactory().constructCollectionType(
						(Class<? extends Collection>) type,
						Class.forName(((ParameterizedType) genericType).getActualTypeArguments()[0].getTypeName())));
			} catch (ClassNotFoundException e) {
				reader = mapper.readerFor(type);
			}

		} else if (String.class.isAssignableFrom(type)) {
			// TODO: please improve
			// return string type without any parsing
			return IOUtils.toString(entityStream, StandardCharsets.UTF_8);
		} else {
			reader = mapper.readerFor(type);
		}
		JsonParser jp = reader.getFactory().createParser(entityStream);
		return reader.readValue(jp);
	}

	@Override
	public boolean configure(FeatureContext context) {
		return true;
	}
}
