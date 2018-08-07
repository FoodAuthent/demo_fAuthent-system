package org.foodauthent.model.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;;

public class ObjectMapperUtil {

    private static ObjectMapper MAPPER;

    private ObjectMapperUtil() {
	// utility class
    }

    public static ObjectMapper getObjectMapper() {
	if (MAPPER == null) {
	    MAPPER = newObjectMapper();
	}
	return MAPPER;
    }

    public static ObjectMapper newObjectMapper() {
	final ObjectMapper mapper = new ObjectMapper();
	mapper.registerModule(new Jdk8Module());
	mapper.registerModule(new JavaTimeModule());
	//mapper.registerModule(new JSR353Module());
	mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
	mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
	ModelUtil.addModelMixIns(mapper);
	return mapper;
    }

}
