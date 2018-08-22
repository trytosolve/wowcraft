package com.iredko.wowcraft2.controllers.lot;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class LotForm {

    private Integer id;

    private Integer itemId;

    private Integer count;

    @NotNull
    private BigDecimal price;

    public LotForm() {
    }

    public LotForm(Integer id, Integer itemId, Integer count, BigDecimal price) {
        this.id = id;
        this.itemId = itemId;
        this.count = count;
        this.price = price;
    }

    public static LotForm fromModel(LotInfoModel lotInfoModel) {
        return new LotForm(lotInfoModel.getId() ,lotInfoModel.getItemId(),lotInfoModel.getCount(),lotInfoModel.getPrice());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
