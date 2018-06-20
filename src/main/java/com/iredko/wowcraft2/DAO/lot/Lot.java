package com.iredko.wowcraft2.DAO.lot;


import com.iredko.wowcraft2.controllers.lot.LotInfoModel;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "lots")
public class Lot {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    public Lot() {
    }

    public Lot(Integer id, String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public static Lot fromModel(LotInfoModel lotInfoModel) {
        return new Lot(lotInfoModel.getId(),lotInfoModel.getName(),lotInfoModel.getPrice());
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
