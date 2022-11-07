package com.majorkeytech.mktprode.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

import static java.lang.Boolean.FALSE;

@Configuration
public class ObjectMapperConfiguration {
    public static ObjectMapper configureObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, FALSE);
        return mapper;
    }
}
