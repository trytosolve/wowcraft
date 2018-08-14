package com.iredko.wowcraft2.controllers.stock;

import com.iredko.wowcraft2.controllers.lot.LotInfoModel;
import com.iredko.wowcraft2.dao.lot.Lot;
import com.iredko.wowcraft2.dao.stock.StockBrunch;

import java.math.BigDecimal;

public class StockBrunchInfoModel {

    private Integer id;

    private String name;

    private Integer count;

    private BigDecimal price;

    public StockBrunchInfoModel(Integer id, String name, Integer count, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public static StockBrunchInfoModel fromEntity(StockBrunch stockBrunch) {
        return new StockBrunchInfoModel(stockBrunch.getId(), stockBrunch.getName(),
                stockBrunch.getCount(), stockBrunch.getPrice());
    }

    public static StockBrunchInfoModel fromLotModel(LotInfoModel lot) {
        return new StockBrunchInfoModel(null, lot.getName(),
                lot.getCount(), lot.getPrice());

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
