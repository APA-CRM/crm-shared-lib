package com.crm.sharedlib.core.enums;

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
    FILES("Files"),
    TASKS("Tasks"),
    TASK_PRIORITIES("Task Priorities"),
    TASK_STATUSES("Task Statuses");

    /**
     * @deprecated Remove this field. Formating must on the front-end side
     */
    @JsonValue
    @Deprecated(since = "0.2.2-SNAPSHOT")
    private final String name;

}
