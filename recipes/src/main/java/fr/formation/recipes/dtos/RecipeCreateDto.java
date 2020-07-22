package fr.formation.recipes.dtos;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.formation.recipes.Difficulty;
import fr.formation.recipes.validation.IncrementalStepOrders;
import fr.formation.recipes.validation.NotSameTimes;
import fr.formation.recipes.validation.UniqueRecipe;

@NotSameTimes
public class RecipeCreateDto {

    @UniqueRecipe
    @Size(min = 3, max = 255)
    @NotBlank
    private String name;

    @Min(1)
    @Max(120)
    private int preparingTime;

    @Min(1)
    @Max(240)
    private Integer cookingTime;

    @Min(1)
    @Max(10)
    private int servings;

    @NotNull
    private Difficulty difficulty;

    @NotBlank
    @Size(min = 7, max = 2500)
    private String imageUrl;

    @Valid
    @NotNull
    @Size(min = 1, max = 50)
    private List<IngredientCreateDto> ingredients;

    @NotNull
    @Size(min = 1, max = 20)
    @IncrementalStepOrders
    private List<@Valid StepCreateDto> steps;
    // @Valid
    // private StepCreateDto step;

    public RecipeCreateDto() {
	//
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getPreparingTime() {
	return preparingTime;
    }

    public void setPreparingTime(int preparingTime) {
	this.preparingTime = preparingTime;
    }

    public Integer getCookingTime() {
	return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
	this.cookingTime = cookingTime;
    }

    public int getServings() {
	return servings;
    }

    public void setServings(int servings) {
	this.servings = servings;
    }

    public Difficulty getDifficulty() {
	return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
	this.difficulty = difficulty;
    }

    public String getImageUrl() {
	return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
    }

    public List<IngredientCreateDto> getIngredients() {
	return ingredients;
    }

    public void setIngredients(List<IngredientCreateDto> ingredients) {
	this.ingredients = ingredients;
    }

    public List<StepCreateDto> getSteps() {
	return steps;
    }

    public void setSteps(List<StepCreateDto> steps) {
	this.steps = steps;
    }
}
