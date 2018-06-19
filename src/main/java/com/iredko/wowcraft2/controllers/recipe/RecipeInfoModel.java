package com.iredko.wowcraft2.controllers.recipe;

import com.iredko.wowcraft2.DAO.recipe.Recipe;
import com.iredko.wowcraft2.DAO.recipe_reagent.RecipeReagent;
import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeInfoModel {

    private Integer id;

    private String name;

    private Map<ReagentInfoModel,Integer> reagenCountMap;

    private Integer price;

    public RecipeInfoModel(Integer id, String name, Map<ReagentInfoModel, Integer> reagenCountMap, Integer price) {
        this.id = id;
        this.name = name;
        this.reagenCountMap = reagenCountMap;
        this.price = price;
    }

    public static RecipeInfoModel fromEntity(Recipe recipe) {
        Map<ReagentInfoModel, Integer> reagentModelsCountMap = new HashMap<>();
        for (RecipeReagent recipeReagents : recipe.getReagents()) {
            reagentModelsCountMap.put(ReagentInfoModel.fromEntity(recipeReagents.getReagent()),recipeReagents.getCount());
        }
        return new RecipeInfoModel(recipe.getId(), recipe.getName(), reagentModelsCountMap, recipe.getPrice());
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
        return new RecipeInfoModel(recipeForm.getId(),recipeForm.getName(),reagenCountMap,recipeForm.getPrice());
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
