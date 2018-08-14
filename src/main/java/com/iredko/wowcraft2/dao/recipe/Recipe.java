package com.iredko.wowcraft2.dao.recipe;

import com.iredko.wowcraft2.dao.reagent.Reagent;
import com.iredko.wowcraft2.dao.recipe_reagent.RecipeReagent;
import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;
import com.iredko.wowcraft2.controllers.recipe.RecipeInfoModel;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "recipes")
@NamedQueries({
        @NamedQuery(name = "Recipe.findAllByReagentId",
        query = "select r from Recipe r inner join r.reagents reagents where reagents.reagent = :reagent")}
)
public class Recipe {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeReagent> reagents = new ArrayList<>();

    @Column(name = "sell_price")
    private BigDecimal sellPrice;

    public Recipe() {
    }

    public Recipe(Integer id, String name, BigDecimal sellPrice) {
        this.id = id;
        this.name = name;
        this.sellPrice = sellPrice;
    }

    public void addReagent(Reagent reagent, Integer count) {
        RecipeReagent recipeReagent = new RecipeReagent(this, reagent, count);
        reagents.add(recipeReagent);
    }

    public static Recipe fromModel(RecipeInfoModel recipeInfoModel) {
        Recipe recipe = new Recipe(recipeInfoModel.getId(), recipeInfoModel.getName(), recipeInfoModel.getSellPrice());
        List<RecipeReagent> recipeReagents = new ArrayList<>();
        for (Map.Entry<ReagentInfoModel, Integer> entry : recipeInfoModel.getReagenCountMap().entrySet()) {
            recipe.addReagent(Reagent.fromModel(entry.getKey()), entry.getValue());
        }
        return recipe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeReagent> getReagents() {
        return reagents;
    }

    public void setReagents(List<RecipeReagent> reagents) {
        this.reagents = reagents;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }
}
