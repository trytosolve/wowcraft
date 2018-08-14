package com.iredko.wowcraft2.dao.recipe_reagent;

import com.iredko.wowcraft2.dao.reagent.Reagent;
import com.iredko.wowcraft2.dao.recipe.Recipe;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="recipes_reagents")
public class RecipeReagent {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "reagent_id")
    private Reagent reagent;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Column(name = "count")
    private Integer count;

    public RecipeReagent() {
    }

    public RecipeReagent(Recipe recipe,Reagent reagent, Integer count) {
        this.reagent = reagent;
        this.recipe = recipe;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reagent getReagent() {
        return reagent;
    }

    public void setReagent(Reagent reagent) {
        this.reagent = reagent;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}