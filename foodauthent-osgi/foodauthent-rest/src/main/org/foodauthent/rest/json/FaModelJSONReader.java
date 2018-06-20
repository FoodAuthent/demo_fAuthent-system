package org.foodauthent.rest.json;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import org.foodauthent.model.FaModel;
import org.foodauthent.model.json.ObjectMapperUtil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class FaModelJSONReader implements MessageBodyReader<FaModel> {

    private final ObjectMapper mapper = ObjectMapperUtil.getObjectMapper();

    @Override
    public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
	return FaModel.class.isAssignableFrom(arg0);
    }

    @Override
    public FaModel readFrom(final Class<FaModel> type, final Type genericType, final Annotation[] annotations,
	    final MediaType mediaType, final MultivaluedMap<String, String> httpHeaders, final InputStream entityStream)
	    throws IOException, WebApplicationException {
	ObjectReader reader = mapper.reader(type);
	JsonParser jp = reader.getFactory().createParser(entityStream);
	return reader.readValue(jp);
    }
}
