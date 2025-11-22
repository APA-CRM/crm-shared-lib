package com.crm.sharedlib.exception.advice;

import com.crm.sharedlib.exception.ForbiddenException;
import com.crm.sharedlib.exception.response.CrmErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ForbiddenControllerAdvice implements Ordered {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenException.class)
    public CrmErrorResponse crmErrorResponse(ForbiddenException e) {
        return new CrmErrorResponse(e.getMessage());
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
