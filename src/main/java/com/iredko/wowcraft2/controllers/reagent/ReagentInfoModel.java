package com.iredko.wowcraft2.controllers.reagent;

import com.iredko.wowcraft2.dao.reagent.Reagent;

import java.math.BigDecimal;

public class ReagentInfoModel {

    private Integer id;

    private String name;

    private BigDecimal sellPrice;

    public ReagentInfoModel() {
    }

    public ReagentInfoModel(Integer id, String name, BigDecimal sellPrice) {
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

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }
}
