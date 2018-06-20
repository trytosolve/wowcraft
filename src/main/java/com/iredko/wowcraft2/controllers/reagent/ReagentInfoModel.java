package com.iredko.wowcraft2.controllers.reagent;

import com.iredko.wowcraft2.DAO.reagent.Reagent;

public class ReagentInfoModel {

    private Integer id;

    private String name;

    private Integer sellPrice;

    public ReagentInfoModel() {
    }

    public ReagentInfoModel(Integer id, String name, Integer sellPrice) {
        this.id = id;
        this.name = name;
        this.sellPrice = sellPrice;
    }

    public static ReagentInfoModel fromEntity(Reagent reagent) {
        return new ReagentInfoModel(reagent.getId(), reagent.getName(), reagent.getSellPrice());
    }

    public static ReagentInfoModel fromForm(ReagentForm reagentForm) {
        return new ReagentInfoModel(reagentForm.getId(), reagentForm.getName(), reagentForm.getSellPrice());
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

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }
}
