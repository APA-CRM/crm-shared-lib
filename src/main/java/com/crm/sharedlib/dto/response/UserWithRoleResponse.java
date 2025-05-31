package com.crm.sharedlib.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithRoleResponse extends UserResponse {

    private List<RoleLightResponse> roles;

}
