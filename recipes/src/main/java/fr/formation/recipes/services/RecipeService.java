package fr.formation.recipes.services;

import fr.formation.recipes.dtos.RecipeCreateDto;

public interface RecipeService {

    void create(RecipeCreateDto dto);

    boolean uniqueName(String value);
}
