package com.crm.sharedlib.dto.request;

import com.crm.sharedlib.validation.AccessControlConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AccessControlConstraint
public class RoleRequest {

    @NotBlank(message = "Name can't be blank")
    private String name;

    private List<ResourceWithActionsRequest> resources;

}
