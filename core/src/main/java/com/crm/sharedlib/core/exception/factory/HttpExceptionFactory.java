package com.crm.sharedlib.core.exception.factory;

import com.crm.sharedlib.core.exception.*;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

@UtilityClass
public class HttpExceptionFactory {

    public static RuntimeException of(int status, String message) {

        HttpStatus httpStatus = HttpStatus.valueOf(status);

        return switch (httpStatus) {
            case HttpStatus.NOT_FOUND -> new NotFoundException(message);

            case HttpStatus.FORBIDDEN -> new ForbiddenException(message);

            case HttpStatus.CONFLICT -> new ConflictException(message);

            case HttpStatus.UNAUTHORIZED -> new UnauthorizedException(message);

            case HttpStatus.BAD_REQUEST -> new BadRequestException(message);

            default -> new RuntimeException("Something went wrong");
        };
    }

}
