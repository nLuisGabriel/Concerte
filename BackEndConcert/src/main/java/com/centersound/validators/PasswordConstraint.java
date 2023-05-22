package com.centersound.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ ElementType.FIELD })
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordConstraint {
    String message() default
            "Password must have: 1 Capital Letter, 1 Small Letter, 1 Digit and 1 Symbol!";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
