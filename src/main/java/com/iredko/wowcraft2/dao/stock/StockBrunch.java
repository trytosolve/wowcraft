package com.iredko.wowcraft2.dao.stock;

import com.iredko.wowcraft2.controllers.stock.StockBrunchInfoModel;

import javax.persistence.*;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "stock")
public class StockBrunch {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "count")
    private Integer count;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "price_for_one")
    private BigDecimal priceForOne;

    public StockBrunch() {
    }

    public StockBrunch(Integer id, String name, Integer count, BigDecimal price, BigDecimal priceForOne) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.priceForOne = priceForOne;
    }

    public static StockBrunch fromModel(StockBrunchInfoModel stockBrunchInfoModel) {
        return new StockBrunch(stockBrunchInfoModel.getId(),stockBrunchInfoModel.getName(),
                stockBrunchInfoModel.getCount(),stockBrunchInfoModel.getPrice(),stockBrunchInfoModel.getPriceForOne());
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

    public BigDecimal getPriceForOne() {
        return priceForOne;
    }

    public void setPriceForOne(BigDecimal priceForOne) {
        this.priceForOne = priceForOne;
    }
}
