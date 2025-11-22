package com.crm.sharedlib.exception.advice;

import com.crm.sharedlib.exception.response.CrmErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationControllerAdvice implements Ordered {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CrmErrorResponse crmErrorResponse(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors()
                .getFirst().getDefaultMessage();

        return new CrmErrorResponse(message);
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}