package com.iredko.wowcraft2.controllers.reagent;
import com.iredko.wowcraft2.dao.reagent.Reagent;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ReagentInfoModel {

    private Integer id;

    @NotNull
    @Size(min=2,max = 15,message = "Name size must be between 2 and 15")
    private String name;

    @NotNull
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
