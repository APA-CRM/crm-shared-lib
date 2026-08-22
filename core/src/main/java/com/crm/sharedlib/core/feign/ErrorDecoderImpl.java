package com.crm.sharedlib.core.feign;

import com.crm.sharedlib.core.exception.factory.HttpExceptionFactory;
import com.crm.sharedlib.core.exception.response.CrmErrorResponse;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import tools.jackson.databind.json.JsonMapper;

import static java.util.Objects.nonNull;

public class ErrorDecoderImpl implements ErrorDecoder {

    private final JsonMapper objectMapper;
    private final ErrorDecoder.Default defaultDecoder;

    public ErrorDecoderImpl(JsonMapper objectMapper, Default defaultDecoder) {
        this.objectMapper = objectMapper;
        this.defaultDecoder = defaultDecoder;
    }

    public ErrorDecoderImpl() {
        this(new JsonMapper(), new Default());
    }

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
