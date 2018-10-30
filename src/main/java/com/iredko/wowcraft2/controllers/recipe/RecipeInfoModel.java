package com.iredko.wowcraft2.controllers.recipe;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iredko.wowcraft2.dao.recipe.Recipe;
import com.iredko.wowcraft2.dao.recipe_reagent.RecipeReagent;
import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeInfoModel {

    private Integer id;

    private String name;

    @JsonSerialize(keyUsing = ReagentInfoModelSerializer.class)
    private Map<ReagentInfoModel,Integer> reagenCountMap;

    private BigDecimal sellPrice;

    public RecipeInfoModel(Integer id, String name, Map<ReagentInfoModel, Integer> reagenCountMap, BigDecimal sellPrice) {
        this.id = id;
        this.name = name;
        this.reagenCountMap = reagenCountMap;
        this.sellPrice = sellPrice;
    }

    public static RecipeInfoModel fromEntity(Recipe recipe) {
        Map<ReagentInfoModel, Integer> reagentModelsCountMap = new HashMap<>();
        for (RecipeReagent recipeReagents : recipe.getReagents()) {
            reagentModelsCountMap.put(ReagentInfoModel.fromEntity(recipeReagents.getReagent()),recipeReagents.getCount());
        }
        return new RecipeInfoModel(recipe.getId(), recipe.getName(), reagentModelsCountMap, recipe.getSellPrice());
    }

    public static RecipeInfoModel fromForm(RecipeForm recipeForm, List<ReagentInfoModel> reagentList) {
        Map<ReagentInfoModel, Integer> reagenCountMap = new HashMap<>();
        for (Map.Entry<Integer,Integer> entry : recipeForm.getReagentCountMap().entrySet()) {
            for (ReagentInfoModel reagent : reagentList) {
                if (entry.getKey().equals(reagent.getId())) {
                    reagenCountMap.put(reagent, entry.getValue());
                }
            }
        }
        return new RecipeInfoModel(recipeForm.getId(),recipeForm.getName(),reagenCountMap,recipeForm.getSellPrice());
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

    public Map<ReagentInfoModel, Integer> getReagenCountMap() {
        return reagenCountMap;
    }

    public void setReagenCountMap(Map<ReagentInfoModel, Integer> reagenCountMap) {
        this.reagenCountMap = reagenCountMap;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

}
