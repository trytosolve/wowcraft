package com.iredko.wowcraft.entities;


import javax.persistence.*;

//TODO схема не должна задаваться в описании ентити. Это очень плохая практика - имя базы данных по сути своей - часть инфы про коннекшн вцелом
@Entity(name = "RecipeReagent")
@Table(name = "recipes_reagents", schema = "craft", catalog = "")
public class RecipeReagent{

    @EmbeddedId
    private RecipeReagentId id;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    private Recipe recipe; //TODO : ты не используешь ссылку на рецепт отсюда. Зачем он тебе здесь?

    @ManyToOne
    @MapsId("reagentId")
    @JoinColumn(name = "reagent_id")
    private Reagent reagent;

    @Column(name = "reg_count")
    private Integer regCount;

    public RecipeReagent() {
    }

    public RecipeReagent(Recipe recipe, Reagent reagent, Integer reg_count) {
        this.recipe = recipe;
        this.reagent = reagent;
        this.regCount = reg_count;
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

    public Integer getReg_count() {
        return regCount;
    }

    //TODO странное имя сеттера
    public void setReg_count(Integer reg_count) {
        this.regCount = reg_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeReagent that = (RecipeReagent) o;

        if (!recipe.equals(that.recipe)) return false;
        if (!reagent.equals(that.reagent)) return false;
        return regCount.equals(that.regCount);
    }

    @Override
    public int hashCode() {
        int result = recipe.hashCode();
        result = 31 * result + reagent.hashCode();
        result = 31 * result + regCount.hashCode();
        return result;
    }
}
