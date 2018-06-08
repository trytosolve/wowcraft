package com.iredko.wowcraft.controllers.reagent;

import com.iredko.wowcraft.DAO.reagent.Reagent;

public class ReagentModel{

    private int id;

    private String name;

    private Integer itemLvl;

    private Integer maxStack;

    private Integer sellPrice;

    public ReagentModel() {
    }

    public ReagentModel(Reagent reagent) {
        this.id = reagent.getId();
        this.name = reagent.getName();
        this.itemLvl = reagent.getItemLvl();
        this.maxStack = reagent.getMaxStack();
        this.sellPrice = reagent.getSellPrice();
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

    public Integer getItemLvl() {
        return itemLvl;
    }

    public void setItemLvl(Integer itemLvl) {
        this.itemLvl = itemLvl;
    }

    public Integer getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(Integer maxStack) {
        this.maxStack = maxStack;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }
}


