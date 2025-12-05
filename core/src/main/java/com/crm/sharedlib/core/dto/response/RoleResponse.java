package com.crm.sharedlib.core.dto.response;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class RoleResponse {

    private Long id;

    private String name;

    private List<AccessControlResponse> accessControls;

    private Instant createdAt;

    private Instant updateAt;

}
