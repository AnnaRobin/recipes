package fr.formation.recipes.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import fr.formation.recipes.dtos.RecipeCreateDto;
import fr.formation.recipes.entities.Recipe;
import fr.formation.recipes.repositories.RecipeJpaRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final ModelMapper mapper;

    private final RecipeJpaRepository repo;

    public RecipeServiceImpl(ModelMapper mapper, RecipeJpaRepository repo) {
	this.mapper = mapper;
	this.repo = repo;
    }

    @Override
    public void create(RecipeCreateDto dto) {
	// ModelMapper
	Recipe recipe = mapper.map(dto, Recipe.class);
	// Par défaut :
	// Repose sur les conventions Javabeans
	// Rechercher les correspondances (mapping)
	// entre les propriétés sources et destination
	// Correspondance exactes dans le nommage field/get/set
	// Correspondance dans le typage des variables
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
