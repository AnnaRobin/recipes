package fr.formation.recipes.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueRecipeValidator.class)
public @interface UniqueRecipe {

    String message() default "Le nom de la recette doit être unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
