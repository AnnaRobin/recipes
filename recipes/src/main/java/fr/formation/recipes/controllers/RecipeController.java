package fr.formation.recipes.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.recipes.dtos.RecipeCreateDto;
import fr.formation.recipes.services.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
	this.service = service;
    }

    @PostMapping
    public void create(@Valid @RequestBody RecipeCreateDto dto) {
	service.create(dto);
    }
}
