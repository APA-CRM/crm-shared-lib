package com.crm.sharedlib.core.dto.amqp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// TODO: Use prefix 'Message' instead of Event
public class SendPasswordByEmailEvent {

    private String email;

    private String password;

}
