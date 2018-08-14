package com.iredko.wowcraft2.controllers.lot;

import com.iredko.wowcraft2.dao.lot.Lot;

import java.math.BigDecimal;

public class LotInfoModel {

    private Integer id;

    private String name;

    private Integer count;

    private BigDecimal price;

    public LotInfoModel() {
    }

    public LotInfoModel(Integer id, String name, Integer count, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public static LotInfoModel fromEntity(Lot lot) {
        return new LotInfoModel(lot.getId(), lot.getName(), lot.getCount(), lot.getPrice());
    }

    public static LotInfoModel fromForm(LotForm lotForm) {
        return new LotInfoModel(lotForm.getId(), lotForm.getName(), lotForm.getCount(), lotForm.getPrice());
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
