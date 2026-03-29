package com.crm.sharedlib.messaging.dto.amqp;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgCreatedMessage {

    private Long organizationId;

    private String organizationName;

}
