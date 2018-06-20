package com.iredko.wowcraft2.DAO.reagent;

import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="reagents")
public class Reagent {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="sell_price")
    private Integer sellPrice;

    public Reagent() {
    }

    public Reagent(Integer id,String name, Integer sellPrice) {
        this.id = id;
        this.name = name;
        this.sellPrice = sellPrice;
    }

    public static Reagent fromModel(ReagentInfoModel reagentInfoModel) {
        return new Reagent(reagentInfoModel.getId(),reagentInfoModel.getName(),reagentInfoModel.getSellPrice());
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

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }
}
