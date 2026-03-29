package com.crm.sharedlib.messaging.dto.amqp;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgRootDirCreatedMessage {

    private Long organizationId;

    private UUID fileId;

}
