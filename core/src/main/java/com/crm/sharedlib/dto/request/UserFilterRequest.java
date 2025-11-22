package com.crm.sharedlib.dto.request;

import com.crm.sharedlib.dto.DateRange;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFilterRequest extends BaseFilterRequest {

    private String login;

    private String email;

    private String firstName;

    private String lastName;

    private DateRange createdDate;

    private DateRange updatedDate;

}
