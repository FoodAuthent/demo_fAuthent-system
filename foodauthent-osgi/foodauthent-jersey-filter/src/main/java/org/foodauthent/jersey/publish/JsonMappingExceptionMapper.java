package org.foodauthent.jersey.publish;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.JsonMappingException;

@Provider
public class JsonMappingExceptionMapper implements ExceptionMapper<JsonMappingException> {

	@Override
	public Response toResponse(JsonMappingException ex) {
		return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).type(MediaType.TEXT_PLAIN)
				.entity(ex.getOriginalMessage()).build();
	}
}
