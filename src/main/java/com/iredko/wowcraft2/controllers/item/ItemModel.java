package com.iredko.wowcraft2.controllers.item;

import com.iredko.wowcraft2.controllers.lot.AuctionInfo;
import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;
import com.iredko.wowcraft2.controllers.recipe.RecipeInfoModel;

import java.math.BigDecimal;
import java.util.Map;

public class ItemModel {

    private RecipeInfoModel recipe;

    private int id;

    private BigDecimal buyPrice;

    private BigDecimal craftPrice;

    public ItemModel(RecipeInfoModel recipe) {
        this.recipe = recipe;
        this.id = recipe.getId();
    }

    public static ItemModel fromRecipe(RecipeInfoModel recipe) {
        return new ItemModel(recipe);
    }

    public BigDecimal calculateBuyPrice(AuctionInfo auctionInfo) {
        return auctionInfo.averagePriceById(id);
    }

    public BigDecimal calculateBuyCraft(AuctionInfo auctionInfo) {
        Map<ReagentInfoModel,Integer> reagentsInfoMap = recipe.getReagenCountMap();
        BigDecimal price = new BigDecimal(0);
        for (Map.Entry<ReagentInfoModel, Integer> entry : reagentsInfoMap.entrySet()) {
            if (auctionInfo.averagePriceById(entry.getKey().getId()) == null) {
                return null;
            }
            price = price.add(auctionInfo.averagePriceById(entry.getKey().getId()).multiply(new BigDecimal(entry.getValue())));
        }
        return price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
