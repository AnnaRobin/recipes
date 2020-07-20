package fr.formation.recipes.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class IngredientCreateDto {

    @NotEmpty
    @Size(min = 1, max = 255)
    private String text;

    public IngredientCreateDto() {
	//
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }
}
