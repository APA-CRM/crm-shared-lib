package com.crm.sharedlib.rbac.aspectj;

import com.crm.sharedlib.core.consts.CrmHeaders;
import com.crm.sharedlib.core.enums.Action;
import com.crm.sharedlib.core.enums.Resource;
import com.crm.sharedlib.core.exception.ForbiddenException;
import com.crm.sharedlib.rbac.annotation.RequiresPermission;
import com.crm.sharedlib.rbac.dto.ResourcePermission;
import com.crm.sharedlib.rbac.dto.UserPermission;
import com.crm.sharedlib.rbac.utils.UserPermissionHeaderSerializer;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class PermissionControlAspect {

    @Before("@annotation(requiresPermission)")
    public void checkPermission(JoinPoint joinPoint, RequiresPermission requiresPermission) {

        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String userPermissionHeaderValue = request.getHeader(CrmHeaders.USER_PERMISSIONS_HEADER_NAME);

        UserPermission userPermission = UserPermissionHeaderSerializer.deserialize(userPermissionHeaderValue);

        for (ResourcePermission resourcePermission : userPermission.getResourcePermissions()) {
            if (isResourcesEqual(resourcePermission.getResource(), requiresPermission.resource())) {

                for (Action action : resourcePermission.getActions()) {
                    if (isActionsEqual(action, requiresPermission.action())) return;
                }

            }
        }

        throw new ForbiddenException("Insufficient permissions");
    }

    private boolean isResourcesEqual(Resource resourceA, Resource resourceB) {
        return resourceA == resourceB || resourceA == Resource.ALL || resourceB == Resource.ALL;
    }

    private boolean isActionsEqual(Action actionA, Action actionB) {
        return actionA == actionB || actionA == Action.ALL || actionB == Action.ALL;
    }

}
