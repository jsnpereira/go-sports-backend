package com.go.sports.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.go.sports.enums.EventType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.registerModule(new JSR310Module());
        mapper.registerModule(eventTypeModuleMapper());
        return mapper;
    }

    public SimpleModule eventTypeModuleMapper() {
        SimpleModule simpleModule = new SimpleModule("JSONEventTypeModule", PackageVersion.VERSION);
        simpleModule.addDeserializer(EventType.class, new EventTypeDeserialize());
        simpleModule.addSerializer(EventType.class, new EventTypeSerializer());
        return simpleModule;
    }

    class EventTypeSerializer extends StdSerializer<EventType> {

        protected EventTypeSerializer() {
            super(EventType.class);
        }

        @Override
        public void serialize(EventType eventType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(eventType.name());
        }
    }

    class EventTypeDeserialize extends StdDeserializer<EventType> {
        public EventTypeDeserialize() {
            super(EventType.class);
        }

        @Override
        public EventType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            String value = jsonParser.getText();
            return EventType.valueOf(value);
        }
    }
}
