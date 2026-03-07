package com.crm.sharedlib.rbac.annotation;

import com.crm.sharedlib.core.enums.Action;
import com.crm.sharedlib.core.enums.Resource;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequiresPermission {

    Resource resource();

    Action action();

}
