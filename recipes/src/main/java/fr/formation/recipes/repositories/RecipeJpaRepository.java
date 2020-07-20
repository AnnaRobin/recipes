package fr.formation.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.recipes.entities.Recipe;

@Repository
public interface RecipeJpaRepository extends JpaRepository<Recipe, Long> {
    // @Query("select count(r.id) from Recipe r where r.name = :value")
    // long uniqueName(String value);

    boolean existsByName(String value);
}
