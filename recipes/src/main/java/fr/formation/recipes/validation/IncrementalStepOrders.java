package fr.formation.recipes.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IncrementalStepOrdersValidator.class)
public @interface IncrementalStepOrders {

    int from() default 1;

    String message() default "Les numéros d'étapes doivent se suivre du min au max";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
