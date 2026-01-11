package com.crm.sharedlib.messaging.dto.amqp;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrgUserRoleChangedMessage {

    private Long organizationId;

    private Long userId;

    private List<Long> rolesIs;

}
