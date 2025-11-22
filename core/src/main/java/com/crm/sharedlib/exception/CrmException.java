package com.crm.sharedlib.exception;

import lombok.Getter;

@Getter
public class CrmException extends RuntimeException {

    private final String message;

    public CrmException(String message) {
        super(message);
        this.message = message;
    }
}
