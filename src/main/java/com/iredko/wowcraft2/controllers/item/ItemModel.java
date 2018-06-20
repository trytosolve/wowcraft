package com.iredko.wowcraft2.controllers.item;

import com.iredko.wowcraft2.controllers.lot.AuctionInfo;
import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;
import com.iredko.wowcraft2.controllers.recipe.RecipeInfoModel;

import java.math.BigDecimal;
import java.util.Map;

public class ItemModel {

    private RecipeInfoModel recipe;

    private String name;

    private BigDecimal buyPrice;

    private BigDecimal craftPrice;

    public ItemModel(RecipeInfoModel recipe) {
        this.recipe = recipe;
        this.name = recipe.getName();
    }

    public static ItemModel fromRecipe(RecipeInfoModel recipe) {
        return new ItemModel(recipe);
    }

    public BigDecimal calculateBuyPrice(AuctionInfo auctionInfo) {
        return auctionInfo.averagePriceByName(name);
    }

    public BigDecimal calculateBuyCraft(AuctionInfo auctionInfo) {
        Map<ReagentInfoModel,Integer> reagentsInfoMap = recipe.getReagenCountMap();
        BigDecimal price = new BigDecimal(0);
        for (Map.Entry<ReagentInfoModel, Integer> entry : reagentsInfoMap.entrySet()) {
            if (auctionInfo.averagePriceByName(entry.getKey().getName()) == null) {
                return null;
            }
            price.add(auctionInfo.averagePriceByName(entry.getKey().getName()).multiply(new BigDecimal(entry.getValue())));
        }
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getCraftPrice() {
        return craftPrice;
    }

    public void setCraftPrice(BigDecimal craftPrice) {
        this.craftPrice = craftPrice;
    }
}
