package fr.formation.recipes.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StepCreateDto {

    @NotBlank
    @Size(min = 1, max = 255)
    private String text;

    @Min(1)
    @Max(20)
    private int stepOrder;

    public StepCreateDto() {
	//
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public int getStepOrder() {
	return stepOrder;
    }

    public void setStepOrder(int value) {
	stepOrder = value;
    }
}
