package bg.softuni.weedinfplanner.model.binding.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnoughBudgetValidator.class)
public @interface EnoughBudget {

    String message() default "Your current budget is not enough for this expense.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
