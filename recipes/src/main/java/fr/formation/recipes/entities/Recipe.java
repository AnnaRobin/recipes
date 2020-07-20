package fr.formation.recipes.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.formation.recipes.Difficulty;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe")
    private Long id;

    @Column(name = "recipe_name")
    private String name;

    @Column(name = "preparing_time_minutes")
    private int preparingTime;

    @Column(name = "cooking_time_minutes")
    private Integer cookingTime;

    private int servings;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Column(name = "dish_image_url")
    private String imageUrl;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_recipe", nullable = false)
    private List<Ingredient> ingredients;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_recipe", nullable = false)
    private List<Step> steps;

    public Recipe() {
	//
    }

    public Long getId() {
	return id;
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

    public List<Ingredient> getIngredients() {
	return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
	this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
	return steps;
    }

    public void setSteps(List<Step> steps) {
	this.steps = steps;
    }
}
