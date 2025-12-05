package com.crm.sharedlib.core.dto.amqp;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// TODO: Use prefix 'Message' instead of Event
public class OrgUserRoleChangedEvent {

    private Long organizationId;

    private Long userId;

    private List<Long> rolesIs;

}
