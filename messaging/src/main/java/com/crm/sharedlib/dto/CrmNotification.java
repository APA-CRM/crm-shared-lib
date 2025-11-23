package com.crm.sharedlib.dto;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CrmNotification {

    private CrmRecipient recipient;

    private CrmMessage message;

    private Map<String, Object> details;

}
