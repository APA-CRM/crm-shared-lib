package com.crm.sharedlib.messaging.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CrmMessage {

    private String code;

    private String message;

    private Map<String, Object> details;
}
