package com.iredko.wowcraft2.controllers.item;

import com.iredko.wowcraft2.controllers.lot.AuctionInfo;
import com.iredko.wowcraft2.controllers.recipe.RecipeInfoModel;
import com.iredko.wowcraft2.service.LotManager;
import com.iredko.wowcraft2.service.RecipeManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/items_prices")
public class ItemsPricesController {

    RecipeManager recipeManager;
    LotManager lotManager;

    public ItemsPricesController(RecipeManager recipeManager, LotManager lotManager) {
        this.recipeManager = recipeManager;
        this.lotManager = lotManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showItems(ModelAndView modelAndView) {
        modelAndView.addObject("items", getItemList());
        modelAndView.setViewName("itemsPrices");
        return modelAndView;
    }

    public List<ItemModel> getItemList() {
        List<ItemModel> listItems = new ArrayList<>();
        AuctionInfo auctionInfo = new AuctionInfo(lotManager.findAll());
        for (RecipeInfoModel recipe : recipeManager.findAll()){
            ItemModel item = ItemModel.fromRecipe(recipe);
            item.setCraftPrice(item.calculateBuyCraft(auctionInfo));
            listItems.add(item);
        }
        return listItems;
    }
}
