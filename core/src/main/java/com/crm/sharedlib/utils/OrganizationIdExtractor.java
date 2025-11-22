package com.crm.sharedlib.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;
import org.springframework.lang.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.crm.sharedlib.consts.CrmConstants.ORGANIZATION_ID_HEADER_NAME;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@UtilityClass
public class OrganizationIdExtractor {

    private static final Pattern PATTERN = Pattern.compile("^/api/organizations/(?<organizationId>\\d+)(/.*)?$");

    @Nullable
    public static Long extractOrganizationIdFromRequest(HttpServletRequest request) {
        Long organizationId = extractFromUri(request.getRequestURI());

        if (isNull(organizationId)) {
            return extractFromHeaders(request);
        }

        return organizationId;
    }

    @Nullable
    public static Long extractOrganizationIdFromRequest(HttpServletRequest request, String uri) {
        Long organizationId = extractFromUri(uri);

        if (isNull(organizationId)) {
            return extractFromHeaders(request);
        }

        return organizationId;
    }

    private static Long extractFromUri(String uri) {
        Matcher matcher = PATTERN.matcher(uri);

        if (matcher.matches()) {
            return Long.valueOf(matcher.group("organizationId"));
        }

        return null;
    }

    private static Long extractFromHeaders(HttpServletRequest request) {
        String organizationId = request.getHeader(ORGANIZATION_ID_HEADER_NAME);

        return nonNull(organizationId) ? Long.valueOf(organizationId) : null;
    }
}
