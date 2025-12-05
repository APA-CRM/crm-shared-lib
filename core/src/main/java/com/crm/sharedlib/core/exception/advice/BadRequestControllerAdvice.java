package com.crm.sharedlib.core.exception.advice;

import com.crm.sharedlib.core.exception.BadRequestException;
import com.crm.sharedlib.core.exception.response.CrmErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BadRequestControllerAdvice implements Ordered {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public CrmErrorResponse crmErrorResponse(BadRequestException e) {
        return new CrmErrorResponse(e.getMessage());
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
