package com.crm.sharedlib.dto.request;

import com.crm.sharedlib.dto.response.UserAndRoles;
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
