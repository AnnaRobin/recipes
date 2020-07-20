package fr.formation.recipes.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.recipes.services.RecipeService;

public class UniqueRecipeValidator
	implements ConstraintValidator<UniqueRecipe, String> {

    // Comment implementation choice
    /*
     * Multi-line
     */
    @Autowired
    private RecipeService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	return service.uniqueName(value); // call service
    }
}
