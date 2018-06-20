package com.iredko.wowcraft2.controllers.lot;

import com.iredko.wowcraft2.DAO.lot.Lot;

public class LotInfoModel {

    private Integer id;

    private String name;

    private Integer price;

    public LotInfoModel() {
    }

    public LotInfoModel(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static LotInfoModel fromEntity(Lot lot) {
        return new LotInfoModel(lot.getId(), lot.getName(), lot.getPrice());
    }

    public static LotInfoModel fromForm(LotForm lotForm) {
        return new LotInfoModel(lotForm.getId(), lotForm.getName(), lotForm.getPrice());
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
