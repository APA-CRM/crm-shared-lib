package com.crm.sharedlib.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Resource {

    ALL("All"),
    USERS("Users"),
    USERS_ROLES("Users-Roles"),
    ORGANIZATIONS("Organizations"),
    ROLES("Roles"),
    INVITATIONS("Invitations"),
    FILES("Files");

    @JsonValue
    private final String name;

}
