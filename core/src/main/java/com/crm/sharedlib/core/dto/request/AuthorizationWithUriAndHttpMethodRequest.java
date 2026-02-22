package com.crm.sharedlib.core.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationWithUriAndHttpMethodRequest extends AuthorizationRequest {

    private String httpMethodName;

    private String uri;

}
