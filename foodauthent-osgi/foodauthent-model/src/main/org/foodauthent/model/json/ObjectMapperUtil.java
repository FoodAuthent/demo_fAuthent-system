package org.foodauthent.model.json;

import org.foodauthent.model.json.ModelUtil;

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
	    MAPPER = new ObjectMapper();
	    MAPPER.registerModule(new Jdk8Module());
	    MAPPER.registerModule(new JavaTimeModule());
	    MAPPER.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
	    MAPPER.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
	    ModelUtil.addModelMixIns(MAPPER);
	}
	return MAPPER;
    }

}
