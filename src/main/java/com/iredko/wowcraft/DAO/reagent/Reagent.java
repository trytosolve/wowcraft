package com.iredko.wowcraft.DAO.reagent;

import com.iredko.wowcraft.DAO.recipe_reagent.RecipeReagent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Reagent")
@Table(name = "reagents")
public class Reagent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;

    @Basic
    @Column(name = "item_lvl", nullable = true)
    private Integer itemLvl;

    @Basic
    @Column(name = "max_stack", nullable = true)
    private Integer maxStack;

    @Basic
    @Column(name = "sell_price", nullable = true)
    private Integer sellPrice;

    //TODO зачем тебе получать список елементов в таблице recipe_reagent вообще?
    @OneToMany(mappedBy = "reagent",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RecipeReagent> recipes = new ArrayList<RecipeReagent>();

    public Reagent(String name, Integer itemLvl, Integer maxStack, Integer sellPrice) {
        this.name = name;
        this.itemLvl = itemLvl;
        this.maxStack = maxStack;
        this.sellPrice = sellPrice;
    }

    public Reagent() {
    }

    public List<RecipeReagent> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeReagent> recipes) {
        this.recipes = recipes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getItemLvl() {
        return itemLvl;
    }

    public void setItemLvl(Integer itemLvl) {
        this.itemLvl = itemLvl;
    }

    public Integer getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(Integer maxStack) {
        this.maxStack = maxStack;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
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
        if (sellPrice != null ? !sellPrice.equals(that.sellPrice) : that.sellPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (itemLvl != null ? itemLvl.hashCode() : 0);
        result = 31 * result + (maxStack != null ? maxStack.hashCode() : 0);
        result = 31 * result + (sellPrice != null ? sellPrice.hashCode() : 0);
        return result;
    }
}
