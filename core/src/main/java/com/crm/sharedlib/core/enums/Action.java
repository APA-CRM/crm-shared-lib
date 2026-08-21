package com.crm.sharedlib.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Action {

    ALL,
    CREATE,
    READ,
    UPDATE,
    DELETE;

}
