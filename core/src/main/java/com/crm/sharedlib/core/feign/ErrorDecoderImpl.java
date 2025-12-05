package com.crm.sharedlib.core.feign;

import com.crm.sharedlib.core.exception.factory.HttpExceptionFactory;
import com.crm.sharedlib.core.exception.response.CrmErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;

import static java.util.Objects.nonNull;

public class ErrorDecoderImpl implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final ErrorDecoder.Default defaultDecoder = new Default();

    @Override
    @SneakyThrows
    public Exception decode(String s, Response response) {

        CrmErrorResponse value =
                objectMapper.readValue(response.body().asInputStream(), CrmErrorResponse.class);

        if (nonNull(value.getMessage())) {
            return HttpExceptionFactory.of(response.status(), value.getMessage());
        }

        return defaultDecoder.decode(s, response);
    }

}
