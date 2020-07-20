package fr.formation.recipes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "steps")
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_step")
    private Long id;

    @Column(name = "step_wording")
    private String text;

    @Column(name = "step_order")
    private int stepOrder;

    public Step() {
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

    public int getStepOrder() {
	return stepOrder;
    }

    public void setStepOrder(int stepOrder) {
	this.stepOrder = stepOrder;
    }
}
