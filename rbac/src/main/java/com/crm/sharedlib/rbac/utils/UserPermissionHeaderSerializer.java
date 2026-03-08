package com.crm.sharedlib.rbac.utils;

import com.crm.sharedlib.core.enums.Action;
import com.crm.sharedlib.core.enums.Resource;
import com.crm.sharedlib.rbac.dto.ResourcePermission;
import com.crm.sharedlib.rbac.dto.UserPermission;
import lombok.experimental.UtilityClass;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@UtilityClass
public class UserPermissionHeaderSerializer {

    private static final String RESOURCES_SEPARATOR = ";";
    private static final String ACTIONS_SEPARATOR = ",";
    private static final String RESOURCE_ACTIONS_SEPARATOR = ":";

    public static String serialize(UserPermission userPermission) {
        Assert.notEmpty(userPermission.getResourcePermissions(), "User permissions is empty");

        StringBuilder stringBuilder = new StringBuilder();

        for (ResourcePermission resourcePermission : userPermission.getResourcePermissions()) {
            Resource resource = resourcePermission.getResource();
            List<Action> actions = resourcePermission.getActions();

            stringBuilder.append(resource.name());
            stringBuilder.append(RESOURCE_ACTIONS_SEPARATOR);

            for (int i = 0; i < actions.size(); i++) {
                stringBuilder.append(actions.get(i).name());

                if (i != actions.size() - 1) {
                    stringBuilder.append(ACTIONS_SEPARATOR);
                }
            }

            stringBuilder.append(RESOURCES_SEPARATOR);
        }

        return stringBuilder.toString();
    }

    public static UserPermission deserialize(String headerValue) {
        Assert.hasText(headerValue, "User permissions is empty");

        ArrayList<ResourcePermission> permissions = new ArrayList<>();

        String[] stringUserPermissions = headerValue.split(RESOURCES_SEPARATOR);

        for (String userPermission : stringUserPermissions) {
            String[] resourceAndActions = userPermission.split(RESOURCE_ACTIONS_SEPARATOR);
            Assert.isTrue(resourceAndActions.length == 2, "Invalid permission format: " + userPermission);

            Resource resource = Resource.valueOf(resourceAndActions[0]);

            List<Action> actionsList = Stream.of(resourceAndActions[1].split(ACTIONS_SEPARATOR))
                    .map(Action::valueOf)
                    .toList();

            ResourcePermission resourcePermission = new ResourcePermission();
            resourcePermission.setResource(resource);
            resourcePermission.setActions(actionsList);

            permissions.add(resourcePermission);
        }

        return new UserPermission(permissions);
    }

}
