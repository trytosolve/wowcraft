package com.iredko.wowcraft.entities;


import javax.persistence.*;

//TODO схема не должна задаваться в описании ентити. Это очень плохая практика - имя базы данных по сути своей - часть инфы про коннекшн вцелом
@Entity(name = "RecipeReagent")
@Table(name = "recipes_reagents", schema = "craft", catalog = "")
public class RecipeReagent{

    @EmbeddedId
    private RecipeReagentId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    private Recipe recipe; //TODO : ты не используешь ссылку на рецепт отсюда. Зачем он тебе здесь?

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("reagentId")
    @JoinColumn(name = "reagent_id")
    private Reagent reagent;

    @Column(name = "reg_count")
    private Integer reagentQuantity;

    public RecipeReagent() {
    }

    public RecipeReagent(Recipe recipe, Reagent reagent,Integer reagentQuantity) {
        this.reagentQuantity = reagentQuantity;
        this.recipe = recipe;
        this.reagent = reagent;
        this.id = new RecipeReagentId(recipe.getId(),reagent.getId());
    }

    public RecipeReagentId getId() {
        return id;
    }

    public void setId(RecipeReagentId id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Reagent getReagent() {
        return reagent;
    }

    public void setReagent(Reagent reagent) {
        this.reagent = reagent;
    }

    public Integer getReagentQuantity() {
        return reagentQuantity;
    }

    public void setReagentQuantity(Integer reagentQuantity) {
        this.reagentQuantity = reagentQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeReagent that = (RecipeReagent) o;

        if (!recipe.equals(that.recipe)) return false;
        if (!reagent.equals(that.reagent)) return false;
        return reagentQuantity.equals(that.reagentQuantity);
    }

    @Override
    public int hashCode() {
        int result = recipe.hashCode();
        result = 31 * result + reagent.hashCode();
        result = 31 * result + reagentQuantity.hashCode();
        return result;
    }
}
