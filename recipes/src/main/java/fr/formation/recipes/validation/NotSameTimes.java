package fr.formation.recipes.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotSameTimesValidator.class)
public @interface NotSameTimes {

    String message() default "Les temps de préparation et de cuisson doivent être différents";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
