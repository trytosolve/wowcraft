package com.iredko.wowcraft2.controllers.lot;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class LotForm {
    private Integer id;

    @Size(min=2,max = 15,message = "Name size must be between 2 and 15")
    private String name;

    private Integer count;

    @NotNull
    private BigDecimal price;

    public LotForm() {
    }

    public LotForm(Integer id, String name,Integer count, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public static LotForm fromModel(LotInfoModel lotInfoModel) {
        return new LotForm(lotInfoModel.getId(), lotInfoModel.getName(), lotInfoModel.getCount(),lotInfoModel.getPrice());
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
