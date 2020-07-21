package fr.formation.recipes.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.recipes.dtos.StepCreateDto;

public class IncrementalStepOrdersValidator implements
	ConstraintValidator<IncrementalStepOrders, List<StepCreateDto>> {

    private int from;

    @Override
    public void initialize(IncrementalStepOrders annotation) {
	from = annotation.from(); // 2 instead of 1 (default)
	if (from < 1) {
	    throw new IllegalArgumentException(
		    "from parameter must not be less than 1: " + from);
	}
    }

    @Override
    public boolean isValid(List<StepCreateDto> values,
	    ConstraintValidatorContext context) {
	if (values == null || values.isEmpty()) {
	    return true;
	}
	//
	boolean valid = true;
	int previous = from;
	for (StepCreateDto stepCreateDto : values) {
	    int current = stepCreateDto.getStepOrder();
	    if (current != previous++) {
		valid = false;
		break;
	    }
	}
	return valid;
    }
}
