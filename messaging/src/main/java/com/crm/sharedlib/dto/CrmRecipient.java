package com.crm.sharedlib.dto;

import com.crm.sharedlib.enums.RecipientType;
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
