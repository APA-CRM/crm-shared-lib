package com.crm.sharedlib.rbac.utils;

import com.crm.sharedlib.core.enums.Action;
import com.crm.sharedlib.core.enums.Resource;
import com.crm.sharedlib.rbac.dto.ResourcePermission;
import com.crm.sharedlib.rbac.dto.UserPermission;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserPermissionHeaderSerializerTest {

    @Test
    void serialize_singleResourceMultipleActions() {
        ResourcePermission permission = new ResourcePermission();
        permission.setResource(Resource.USERS);
        permission.setActions(List.of(Action.READ, Action.CREATE));

        UserPermission userPermission = new UserPermission(List.of(permission));

        String result = UserPermissionHeaderSerializer.serialize(userPermission);

        assertEquals("USERS:READ,CREATE;", result);
    }

    @Test
    void serialize_multipleResources() {
        ResourcePermission users = new ResourcePermission();
        users.setResource(Resource.USERS);
        users.setActions(List.of(Action.READ));

        ResourcePermission orders = new ResourcePermission();
        orders.setResource(Resource.ORGANIZATIONS);
        orders.setActions(List.of(Action.CREATE, Action.DELETE));

        UserPermission userPermission = new UserPermission(List.of(users, orders));

        String result = UserPermissionHeaderSerializer.serialize(userPermission);

        assertEquals("USERS:READ;ORGANIZATIONS:CREATE,DELETE;", result);
    }

    @Test
    void deserialize_singleResourceMultipleActions() {
        String header = "USERS:READ,CREATE";

        UserPermission result = UserPermissionHeaderSerializer.deserialize(header);

        assertEquals(1, result.getResourcePermissions().size());

        ResourcePermission permission = result.getResourcePermissions().get(0);
        assertEquals(Resource.USERS, permission.getResource());
        assertEquals(List.of(Action.READ, Action.CREATE), permission.getActions());
    }

    @Test
    void deserialize_multipleResources() {
        String header = "USERS:READ;ORGANIZATIONS:CREATE,DELETE";

        UserPermission result = UserPermissionHeaderSerializer.deserialize(header);

        assertEquals(2, result.getResourcePermissions().size());

        ResourcePermission first = result.getResourcePermissions().get(0);
        assertEquals(Resource.USERS, first.getResource());
        assertEquals(List.of(Action.READ), first.getActions());

        ResourcePermission second = result.getResourcePermissions().get(1);
        assertEquals(Resource.ORGANIZATIONS, second.getResource());
        assertEquals(List.of(Action.CREATE, Action.DELETE), second.getActions());
    }

    @Test
    void deserialize_invalidFormat_shouldThrow() {
        String header = "USERS";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> UserPermissionHeaderSerializer.deserialize(header)
        );

        assertTrue(exception.getMessage().contains("Invalid permission format"));
    }

    @Test
    void deserialize_emptyHeader_shouldThrow() {
        assertThrows(
                IllegalArgumentException.class,
                () -> UserPermissionHeaderSerializer.deserialize("")
        );
    }

    @Test
    void serialize_emptyPermissions_shouldThrow() {
        UserPermission userPermission = new UserPermission(List.of());

        assertThrows(
                IllegalArgumentException.class,
                () -> UserPermissionHeaderSerializer.serialize(userPermission)
        );
    }

    @Test
    void serializeDeserialize_roundTrip() {
        ResourcePermission users = new ResourcePermission();
        users.setResource(Resource.USERS);
        users.setActions(List.of(Action.READ, Action.CREATE));

        ResourcePermission organization = new ResourcePermission();
        organization.setResource(Resource.ORGANIZATIONS);
        organization.setActions(List.of(Action.CREATE, Action.DELETE, Action.UPDATE));

        ResourcePermission roles = new ResourcePermission();
        roles.setResource(Resource.ROLES);
        roles.setActions(List.of(Action.ALL));

        UserPermission original = new UserPermission(List.of(users, organization, roles));

        String header = UserPermissionHeaderSerializer.serialize(original);
        UserPermission parsed = UserPermissionHeaderSerializer.deserialize(header);

        assertEquals(original.getResourcePermissions().size(), parsed.getResourcePermissions().size());

        for (int i = 0; i < original.getResourcePermissions().size(); i++) {
            ResourcePermission expected = original.getResourcePermissions().get(i);
            ResourcePermission actual = parsed.getResourcePermissions().get(i);

            assertEquals(expected.getResource(), actual.getResource());
            assertEquals(expected.getActions(), actual.getActions());
        }
    }
}