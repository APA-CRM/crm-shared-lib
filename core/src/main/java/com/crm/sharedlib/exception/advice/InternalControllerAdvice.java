package com.crm.sharedlib.exception.advice;

import com.crm.sharedlib.exception.CrmException;
import com.crm.sharedlib.exception.response.CrmErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class InternalControllerAdvice implements Ordered {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public CrmErrorResponse internalControllerAdvice(RuntimeException e) {
        log.error("Error has occurred", e);
        return new CrmErrorResponse("Something went wrong");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CrmException.class)
    public CrmErrorResponse internalControllerAdvice(CrmException e) {
        return new CrmErrorResponse(e.getMessage());
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
}

