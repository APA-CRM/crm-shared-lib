package com.crm.sharedlib.messaging.dto.amqp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendPasswordByEmailMessage {

    private String email;

    private String password;

}
