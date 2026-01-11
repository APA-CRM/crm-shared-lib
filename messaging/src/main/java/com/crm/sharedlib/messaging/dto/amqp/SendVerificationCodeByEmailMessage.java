package com.crm.sharedlib.messaging.dto.amqp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SendVerificationCodeByEmailMessage {

    private String email;

    private String verificationCode;

}
