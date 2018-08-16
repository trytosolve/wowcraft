package com.iredko.wowcraft2.controllers.lot;

import com.iredko.wowcraft2.dao.lot.Lot;

import java.math.BigDecimal;

public class LotInfoModel {

    private int id;

    private int itemId;

    private Integer count;

    private BigDecimal price;

    public LotInfoModel() {
    }

    public LotInfoModel(int id, int itemId, Integer count, BigDecimal price) {
        this.id = id;
        this.itemId = itemId;
        this.count = count;
        this.price = price;
    }

    public static LotInfoModel fromEntity(Lot lot) {
        return new LotInfoModel(lot.getId() ,lot.getItemId(),lot.getCount(),lot.getPrice());
    }

    public static LotInfoModel fromForm(LotForm lotForm) {
        return new LotInfoModel(lotForm.getId() ,lotForm.getItemId(),lotForm.getCount(),lotForm.getPrice());
    }


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
