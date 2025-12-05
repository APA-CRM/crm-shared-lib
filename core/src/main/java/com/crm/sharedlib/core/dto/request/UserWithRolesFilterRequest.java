package com.crm.sharedlib.core.dto.request;

import com.crm.sharedlib.core.dto.response.UserAndRoles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithRolesFilterRequest extends UserFilterRequest {

    private List<UserAndRoles> userAndRoles;

}
