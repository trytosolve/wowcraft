package com.iredko.wowcraft.DAO.recipe_reagent;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RecipeReagentId implements Serializable {

    @Column(name = "recipe_id")
    private Integer recipeId;

    @Column(name = "reagent_id")
    private Integer reagentId;

    public RecipeReagentId() {
    }

    public RecipeReagentId(Integer recipeId, Integer reagentId) {
        this.recipeId = recipeId;
        this.reagentId = reagentId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getReagentId() {
        return reagentId;
    }

    public void setReagentId(Integer reagentId) {
        this.reagentId = reagentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeReagentId that = (RecipeReagentId) o;

        if (!recipeId.equals(that.recipeId)) return false;
        return reagentId.equals(that.reagentId);
    }

    @Override
    public int hashCode() {
        int result = recipeId.hashCode();
        result = 31 * result + reagentId.hashCode();
        return result;
    }
}
