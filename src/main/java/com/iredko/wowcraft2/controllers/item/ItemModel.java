package com.iredko.wowcraft2.controllers.item;

import com.iredko.wowcraft2.controllers.lot.AuctionInfo;
import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;
import com.iredko.wowcraft2.controllers.recipe.RecipeInfoModel;

import java.util.Map;

public class ItemModel {

    private RecipeInfoModel recipe;

    private String name;

    private Integer buyPrice;

    private Integer craftPrice;

    public ItemModel(RecipeInfoModel recipe) {
        this.recipe = recipe;
        this.name = recipe.getName();
    }

    public static ItemModel fromRecipe(RecipeInfoModel recipe) {
        return new ItemModel(recipe);
    }

    public Integer calculateBuyPrice(AuctionInfo auctionInfo) {
        return auctionInfo.averagePriceByName(name);
    }

    public Integer calculateBuyCraft(AuctionInfo auctionInfo) {
        Map<ReagentInfoModel,Integer> reagentsInfoMap = recipe.getReagenCountMap();
        Integer price = new Integer(0);
        for (Map.Entry<ReagentInfoModel, Integer> entry : reagentsInfoMap.entrySet()) {
            if (auctionInfo.averagePriceByName(entry.getKey().getName()) == null) {
                return null;
            }
            price = price + auctionInfo.averagePriceByName(entry.getKey().getName()) * entry.getValue();
        }
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getCraftPrice() {
        return craftPrice;
    }

    public void setCraftPrice(Integer craftPrice) {
        this.craftPrice = craftPrice;
    }
}
