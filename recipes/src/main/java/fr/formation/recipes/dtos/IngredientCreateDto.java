package fr.formation.recipes.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class IngredientCreateDto {

    @NotBlank
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
