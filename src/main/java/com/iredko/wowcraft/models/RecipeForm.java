package com.iredko.wowcraft.models;

import com.iredko.wowcraft.entities.Reagent;
import com.iredko.wowcraft.entities.Recipe;
import com.iredko.wowcraft.entities.RecipeReagent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeForm {
    private int id;

    private String name;

    private List<Reagent> allReagentList;

    private Map<Integer, Integer> reagentCountMap;

    public RecipeForm() {
    }

    public RecipeForm(Recipe recipe, List<Reagent> allReagentList) {
        this.id = recipe.getId();
        this.name  = recipe.getName();
        this.allReagentList = allReagentList;
        Map<Integer, Integer> map = new HashMap<>();
        for (RecipeReagent recipeReagent : recipe.getReagents()) {
            map.put(recipeReagent.getReagent().getId(), recipeReagent.getReg_count());
            reagentCountMap = map;
        }
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reagent> getAllReagentList() {
        return allReagentList;
    }

    public void setAllReagentList(List<Reagent> allReagentList) {
        this.allReagentList = allReagentList;
    }

    public Map<Integer, Integer> getReagentCountMap() {
        return reagentCountMap;
    }

    public void setReagentCountMap(Map<Integer, Integer> reagentCountMap) {
        this.reagentCountMap = reagentCountMap;
    }
}
