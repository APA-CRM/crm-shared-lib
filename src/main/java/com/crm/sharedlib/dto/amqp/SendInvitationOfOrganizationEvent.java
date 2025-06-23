package com.crm.sharedlib.dto.amqp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendInvitationOfOrganizationEvent {

    private String email;

    private UUID invitationId;

    private String organizationName;

}
