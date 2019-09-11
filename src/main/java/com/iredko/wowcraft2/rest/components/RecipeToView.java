package com.iredko.wowcraft2.rest.components;

import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;
import com.iredko.wowcraft2.controllers.recipe.RecipeInfoModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeToView {

    private Integer id;

    private String name;

    private List<ReagentCount> reagentCountList;

    private BigDecimal sellPrice;

    public RecipeToView() {
    }

    public RecipeToView(Integer id, String name, List<ReagentCount> reagentCountList, BigDecimal sellPrice) {
        this.id = id;
        this.name = name;
        this.reagentCountList = reagentCountList;
        this.sellPrice = sellPrice;
    }

    public static RecipeToView transformToView(RecipeInfoModel recipe) {
        List<ReagentCount> reagentSchema = new ArrayList<>();
        for (Map.Entry<ReagentInfoModel, Integer> entry : recipe.getReagenCountMap().entrySet()) {
            reagentSchema.add(new ReagentCount(entry.getKey(), entry.getValue()));
        }
        return new RecipeToView(recipe.getId(), recipe.getName(), reagentSchema, recipe.getSellPrice());
    }

    public static RecipeInfoModel transformToDB(RecipeToView recipeToView) {
        Map<ReagentInfoModel, Integer> reagentMap = new HashMap<>();
        for (ReagentCount reagentCount : recipeToView.reagentCountList) {
            reagentMap.put(reagentCount.getReagent(), reagentCount.getCount());
        }
        return new RecipeInfoModel(recipeToView.getId(), recipeToView.getName(), reagentMap,
                recipeToView.getSellPrice());
    }

    public static List<RecipeToView> transformListToView(List<RecipeInfoModel> recipeList) {
        List<RecipeToView> listToView = new ArrayList<>();
        for (RecipeInfoModel recipe : recipeList) {
            listToView.add(transformToView(recipe));
        }
        return listToView;
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

    public List<ReagentCount> getReagentCountList() {
        return reagentCountList;
    }

    public void setReagentCountList(List<ReagentCount> reagentCountList) {
        this.reagentCountList = reagentCountList;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }
}
