package com.iredko.wowcraft.entities;

import javax.persistence.*;

@Entity
@Table(name = "reagents", schema = "craft", catalog = "")
public class Reagent {
    private int id;
    private String name;
    private Integer itemLvl;
    private Integer maxStack;
    private Integer cellPrice;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "item_lvl", nullable = true)
    public Integer getItemLvl() {
        return itemLvl;
    }

    public void setItemLvl(Integer itemLvl) {
        this.itemLvl = itemLvl;
    }

    @Basic
    @Column(name = "max_stack", nullable = true)
    public Integer getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(Integer maxStack) {
        this.maxStack = maxStack;
    }

    @Basic
    @Column(name = "cell_price", nullable = true)
    public Integer getCellPrice() {
        return cellPrice;
    }

    public void setCellPrice(Integer cellPrice) {
        this.cellPrice = cellPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reagent that = (Reagent) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (itemLvl != null ? !itemLvl.equals(that.itemLvl) : that.itemLvl != null) return false;
        if (maxStack != null ? !maxStack.equals(that.maxStack) : that.maxStack != null) return false;
        if (cellPrice != null ? !cellPrice.equals(that.cellPrice) : that.cellPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (itemLvl != null ? itemLvl.hashCode() : 0);
        result = 31 * result + (maxStack != null ? maxStack.hashCode() : 0);
        result = 31 * result + (cellPrice != null ? cellPrice.hashCode() : 0);
        return result;
    }
}
