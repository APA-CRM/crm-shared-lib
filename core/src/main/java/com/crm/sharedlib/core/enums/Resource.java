package com.crm.sharedlib.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Resource {

    ALL,
    USERS,
    USERS_ROLES,
    ORGANIZATIONS,
    ROLES,
    INVITATIONS,
    FILES,
    TASKS,
    TASK_PRIORITIES,
    TASK_STATUSES;

}
