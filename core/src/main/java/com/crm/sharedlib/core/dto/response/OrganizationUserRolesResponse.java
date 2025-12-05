package com.crm.sharedlib.core.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationUserRolesResponse {

    private Long organizationId;

    private Long userId;

    private List<Long> rolesId;

}
