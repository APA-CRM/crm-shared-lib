package com.crm.sharedlib.core.dto.request;

import com.crm.sharedlib.core.enums.Action;
import com.crm.sharedlib.core.enums.Resource;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceWithActionsRequest {

    @NotNull(message = "Resource can't be null")
    private Resource resource;

    @Size(min = 1, max = 5, message = "Max size for actions is 5, min size is 1")
    private List<Action> actions;

}
