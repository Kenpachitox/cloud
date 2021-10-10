package com.example.data.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = com.example.data.domain.Payment.class, name = "payment")
})
public interface Payload {
}
