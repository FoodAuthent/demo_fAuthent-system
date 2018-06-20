package org.foodauthent.rest.json;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import org.foodauthent.model.FaModel;
import org.foodauthent.model.json.ObjectMapperUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FaModelJSONWriter implements MessageBodyWriter<FaModel> {

    private final ObjectMapper mapper = ObjectMapperUtil.getObjectMapper();

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
	return FaModel.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(FaModel t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
	return -1;
    }

    @Override
    public void writeTo(final FaModel value, final Class<?> type, final Type genericType,
	    final Annotation[] annotations, final MediaType mediaType, final MultivaluedMap<String, Object> httpHeaders,
	    final OutputStream entityStream) throws JsonGenerationException, JsonMappingException, IOException {
	mapper.writeValue(entityStream, value);
    }
}
