package com.example.api.annotations;

import com.example.api.annotations.validators.UserValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Constraint(validatedBy = UserValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserConstraint {
    String message() default "Invalid login or password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
