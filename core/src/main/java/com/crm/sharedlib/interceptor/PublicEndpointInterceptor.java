package com.crm.sharedlib.interceptor;

import com.crm.sharedlib.exception.response.CrmErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

public abstract class PublicEndpointInterceptor implements HandlerInterceptor {

    protected final ObjectMapper objectMapper = new ObjectMapper();

    protected final AntPathMatcher pathMatcher = new AntPathMatcher();

    public abstract boolean intercept(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception;

    protected abstract List<Endpoint> getPublicEndpoints();

    protected boolean isPublicEndpoint(HttpServletRequest request) {
        HttpMethod httpMethod = HttpMethod.valueOf(request.getMethod());
        String uri = request.getRequestURI();

        return getPublicEndpoints().stream().anyMatch(
                endpoint -> endpoint.getHttpMethod()
                        .stream().anyMatch(matchingHttpMethod -> matchingHttpMethod.equals(httpMethod)) &&
                        pathMatcher.match(endpoint.getUri(), uri)
        );
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (isPublicEndpoint(request)) {
            return true;
        }

        return intercept(request, response, handler);
    }

    @SneakyThrows
    protected void respondWithError(int httpStatus, String message, HttpServletResponse response) {

        CrmErrorResponse errorResponse = new CrmErrorResponse(message);

        String value = objectMapper.writeValueAsString(errorResponse);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(value);
        response.setStatus(httpStatus);
    }
}
