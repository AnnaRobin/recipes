package fr.formation.recipes.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class StepDto {

    @NotEmpty
    @Size(min = 1, max = 255)
    private String text;

    @Min(1)
    @Max(20)
    private int stepOrder;

    public StepDto() {
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
	this.stepOrder = value;
    }
}
