package org.foodauthent.jersey.publish;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.core.JsonParseException;

@Provider
public class JsonParseExceptionMapper implements ExceptionMapper<JsonParseException> {

	@Override
	public Response toResponse(JsonParseException ex) {
		return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).type(MediaType.TEXT_PLAIN)
				.entity(ex.getOriginalMessage()).build();
	}

}
