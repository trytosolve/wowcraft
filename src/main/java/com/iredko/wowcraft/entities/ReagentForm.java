package com.iredko.wowcraft.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//TODO это не entity, его не должно быть в этом пакете
public class ReagentForm {

    private int id;

    @Size(min=2,max = 15,message = "Name size must be between 2 and 15")
    private String name;

    @NotNull
    private Integer itemLvl;

    @NotNull
    private Integer maxStack;

    @NotNull
    private Integer cellPrice;

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

    public Integer getCellPrice() {
        return cellPrice;
    }

    public void setCellPrice(Integer cellPrice) {
        this.cellPrice = cellPrice;
    }
}
