package com.crm.sharedlib.messaging.dto.amqp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendInvitationOfOrganizationMessage {

    private String email;

    private UUID invitationId;

    private String organizationName;

}
