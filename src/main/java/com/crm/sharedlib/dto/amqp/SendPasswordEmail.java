package com.crm.sharedlib.dto.amqp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// TODO: Rename this class: add suffix "Event", remove prefix "Send"
public class SendPasswordEmail {

    private String email;

    private String password;

}
