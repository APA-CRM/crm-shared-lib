package com.crm.sharedlib.validation;

import com.crm.sharedlib.validation.validators.AccessControlonstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(ElementType.TYPE)
@Constraint(validatedBy = AccessControlonstraintValidator.class)
@Retention(RUNTIME)
public @interface AccessControlConstraint {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
