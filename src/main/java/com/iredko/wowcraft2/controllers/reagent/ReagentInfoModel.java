package com.iredko.wowcraft2.controllers.reagent;

import com.iredko.wowcraft2.DAO.reagent.Reagent;

public class ReagentInfoModel {

    private Integer id;

    private String name;

    private Integer price;

    public ReagentInfoModel() {
    }

    public ReagentInfoModel(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static ReagentInfoModel fromEntity(Reagent reagent) {
        return new ReagentInfoModel(reagent.getId(), reagent.getName(), reagent.getPrice());
    }

    public static ReagentInfoModel fromForm(ReagentForm reagentForm) {
        return new ReagentInfoModel(reagentForm.getId(), reagentForm.getName(), reagentForm.getPrice());
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
