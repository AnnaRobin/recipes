package fr.formation.recipes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient")
    private Long id;

    @Column(name = "ingredient_wording")
    private String text;

    public Ingredient() {
	//
    }

    public Long getId() {
	return id;
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }
}
