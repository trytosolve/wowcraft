package com.iredko.wowcraft.controllers.reagent;

import com.iredko.wowcraft.DAO.reagent.Reagent;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReagentForm {

    private int id;

    @Size(min=2,max = 15,message = "Name size must be between 2 and 15")
    private String name;

    @NotNull
    private Integer itemLvl;

    @NotNull
    private Integer maxStack;

    @NotNull
    private Integer sellPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReagentForm() {
    }

    public ReagentForm(Reagent reagent) {
        this.id = reagent.getId();
        this.name = reagent.getName();
        this.itemLvl = reagent.getItemLvl();
        this.maxStack = reagent.getMaxStack();
        this.sellPrice = reagent.getSellPrice();
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
