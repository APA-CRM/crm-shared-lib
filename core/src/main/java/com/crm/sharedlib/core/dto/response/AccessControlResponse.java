package com.crm.sharedlib.core.dto.response;

import com.crm.sharedlib.core.enums.Action;
import com.crm.sharedlib.core.enums.Resource;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AccessControlResponse {

    private Resource resource;

    private List<Action> actions = new ArrayList<>();

}
