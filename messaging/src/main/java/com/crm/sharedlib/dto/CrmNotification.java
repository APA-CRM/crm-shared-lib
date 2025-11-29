package com.crm.sharedlib.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CrmNotification {

    private CrmRecipient recipient;

    private CrmMessage message;

}
