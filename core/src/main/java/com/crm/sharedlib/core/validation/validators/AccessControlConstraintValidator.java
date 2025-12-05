package com.crm.sharedlib.core.validation.validators;

import com.crm.sharedlib.core.dto.request.ResourceWithActionsRequest;
import com.crm.sharedlib.core.dto.request.RoleRequest;
import com.crm.sharedlib.core.enums.Action;
import com.crm.sharedlib.core.enums.Resource;
import com.crm.sharedlib.core.validation.AccessControlConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class AccessControlConstraintValidator
        implements ConstraintValidator<AccessControlConstraint, RoleRequest> {

    @Override
    public boolean isValid(RoleRequest value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        if (isNull(value.getResources()) || value.getResources().isEmpty()) {
            context.buildConstraintViolationWithTemplate("Resources can't be null or empty")
                    .addConstraintViolation();
            return false;
        }

        Map<Resource, List<Action>> map = value.getResources()
                .stream()
                .collect(Collectors.toMap(
                        ResourceWithActionsRequest::getResource,
                        ResourceWithActionsRequest::getActions
                ));

        context.buildConstraintViolationWithTemplate("You can not use the ALL resource with other resources")
                .addConstraintViolation();

        return !(map.containsKey(Resource.ALL) && map.size() > 1);
    }

}
