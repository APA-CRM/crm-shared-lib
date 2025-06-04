package com.crm.sharedlib.dto.amqp;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrgUserRoleChangedEvent {

    private Long organizationId;

    private Long userId;

    private List<Long> rolesIs;

}
