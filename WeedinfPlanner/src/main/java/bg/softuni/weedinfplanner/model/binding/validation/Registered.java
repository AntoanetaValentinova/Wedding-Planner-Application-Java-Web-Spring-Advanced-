package bg.softuni.weedinfplanner.model.binding.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RegisteredValidator.class)
public @interface Registered {

    String message() default "User with this email and password doesn`t exist!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}