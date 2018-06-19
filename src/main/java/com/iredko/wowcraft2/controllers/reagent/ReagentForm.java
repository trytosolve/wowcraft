package com.iredko.wowcraft2.controllers.reagent;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReagentForm {

    private Integer id;

    @Size(min=2,max = 15,message = "Name size must be between 2 and 15")
    private String name;

    @NotNull
    private Integer price;

    public ReagentForm() {
    }

    public ReagentForm(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static ReagentForm fromModel(ReagentInfoModel reagentInfoModel) {
        return new ReagentForm(reagentInfoModel.getId(), reagentInfoModel.getName(), reagentInfoModel.getPrice());
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
