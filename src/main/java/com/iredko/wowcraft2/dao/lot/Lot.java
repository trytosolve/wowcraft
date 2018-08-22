package com.iredko.wowcraft2.dao.lot;


import com.iredko.wowcraft2.controllers.lot.LotInfoModel;

import javax.persistence.*;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "lots")
public class Lot {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "count")
    private Integer count;

    @Column(name = "price")
    private BigDecimal price;

    public Lot() {
    }

    public Lot(Integer itemId, Integer count, BigDecimal price) {
        this.itemId = itemId;
        this.count = count;
        this.price = price;
    }

    public Lot(Integer id,Integer itemId, Integer count, BigDecimal price) {
        this.id = id;
        this.itemId = itemId;
        this.count = count;
        this.price = price;
    }

    public static Lot fromModel(LotInfoModel lotInfoModel) {
        return new Lot(lotInfoModel.getId(),lotInfoModel.getItemId(),lotInfoModel.getCount(),lotInfoModel.getPrice());
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
