package com.iredko.wowcraft.entities;

import java.util.List;
import java.util.Map;

public class RecipeForm {
    private int id;

    private String name;

    private List<Reagent> reagentList;

    private Map<String, Integer> reagentCountMap;

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

    public List<Reagent> getReagentList() {
        return reagentList;
    }

    public void setReagentList(List<Reagent> reagentList) {
        this.reagentList = reagentList;
    }

    public Map<String, Integer> getReagentCountMap() {
        return reagentCountMap;
    }

    public void setReagentCountMap(Map<String, Integer> reagentCountMap) {
        this.reagentCountMap = reagentCountMap;
    }
}
