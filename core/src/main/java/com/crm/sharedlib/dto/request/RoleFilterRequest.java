package com.crm.sharedlib.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleFilterRequest extends BaseFilterRequest {

    private String name;

    private List<Long> rolesId;

}
