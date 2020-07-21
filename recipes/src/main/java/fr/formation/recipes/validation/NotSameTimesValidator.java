package fr.formation.recipes.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.recipes.dtos.RecipeCreateDto;

public class NotSameTimesValidator
	implements ConstraintValidator<NotSameTimes, RecipeCreateDto> {

    @Override
    public boolean isValid(RecipeCreateDto value,
	    ConstraintValidatorContext context) {
	int preparingTime = value.getPreparingTime(); // 1 à 120
	Integer cookingTime = value.getCookingTime(); // null ou 1 à 240
	if (cookingTime == null) {
	    return true;
	}
	return preparingTime != cookingTime;
    }
}
