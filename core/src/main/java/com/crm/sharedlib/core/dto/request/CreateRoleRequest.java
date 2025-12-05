package com.crm.sharedlib.core.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoleRequest extends RoleRequest {

    @NotNull(message = "isDeletable field can't be null")
    private Boolean isDeletable;

}
