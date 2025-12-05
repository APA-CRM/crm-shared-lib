package com.crm.sharedlib.core.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Action {

    ALL("All"),
    CREATE("Create"),
    READ("Read"),
    UPDATE("Update"),
    DELETE("Delete");

    @JsonValue
    private final String name;
}
