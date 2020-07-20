package fr.formation.recipes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.recipes.dtos.IngredientCreateDto;
import fr.formation.recipes.dtos.RecipeCreateDto;
import fr.formation.recipes.dtos.StepDto;
import fr.formation.recipes.entities.Ingredient;
import fr.formation.recipes.entities.Recipe;
import fr.formation.recipes.entities.Step;
import fr.formation.recipes.repositories.RecipeJpaRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeJpaRepository repo;

    public RecipeServiceImpl(RecipeJpaRepository repo) {
	this.repo = repo;
    }

    @Override
    public void create(RecipeCreateDto dto) {
	// Convert dto to entity
	// Recipe attributes
	Recipe recipe = new Recipe();
	recipe.setName(dto.getName());
	recipe.setDifficulty(dto.getDifficulty());
	recipe.setCookingTime(dto.getCookingTime());
	recipe.setImageUrl(dto.getImageUrl());
	recipe.setPreparingTime(dto.getPreparingTime());
	recipe.setServings(dto.getServings());
	// Ingredients
	List<Ingredient> ingredients = new ArrayList<>();
	for (IngredientCreateDto ingredientDto : dto.getIngredients()) {
	    Ingredient ingredient = new Ingredient();
	    ingredient.setText(ingredientDto.getText());
	    ingredients.add(ingredient);
	}
	recipe.setIngredients(ingredients);
	// Steps
	List<Step> steps = new ArrayList<>();
	for (StepDto stepDto : dto.getSteps()) {
	    Step step = new Step();
	    step.setText(stepDto.getText());
	    step.setStepOrder(stepDto.getStepOrder());
	    steps.add(step);
	}
	//
	recipe.setSteps(steps);
	// Save entity
	repo.save(recipe);
    }

    /**
     * Returns true if value does not exists.
     */
    @Override
    public boolean uniqueName(String value) {
	// select recipe where name = value
	// long count = repo.uniqueName(value);
	// return count == 0; //
	return !repo.existsByName(value);
    }
}
