package com.crm.sharedlib.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Resource {

    ALL("All"),
    USERS("Users"),
    ORGANIZATIONS("Organizations");

    @JsonValue
    private final String name;

}
