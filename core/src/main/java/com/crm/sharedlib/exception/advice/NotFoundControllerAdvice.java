package com.crm.sharedlib.exception.advice;

import com.crm.sharedlib.exception.NotFoundException;
import com.crm.sharedlib.exception.response.CrmErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundControllerAdvice implements Ordered {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public CrmErrorResponse notFoundException(NotFoundException e) {
        return new CrmErrorResponse(e.getMessage());
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
