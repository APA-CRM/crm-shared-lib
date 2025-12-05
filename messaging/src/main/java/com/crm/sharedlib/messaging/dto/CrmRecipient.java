package com.crm.sharedlib.messaging.dto;

import com.crm.sharedlib.messaging.enums.RecipientType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CrmRecipient {

    private Long id;

    private RecipientType type;

}
