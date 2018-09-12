package com.iredko.wowcraft2.controllers.recipe;

import com.iredko.wowcraft2.components.stock.CraftStock;
import com.iredko.wowcraft2.controllers.reagent.ReagentForm;
import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;
import com.iredko.wowcraft2.dao.external_stock.BucketDAO;
import com.iredko.wowcraft2.dao.recipe.Recipe;
import com.iredko.wowcraft2.service.ReagentManager;
import com.iredko.wowcraft2.service.RecipeManager;
import com.iredko.wowcraft2.service.StockManager;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/recipes")
public class RecipeController {

    private RecipeManager recipeManager;
    private ReagentManager reagentManager;
    private BucketDAO bucketDAO;

    public RecipeController(RecipeManager recipeManager, ReagentManager reagentManager, BucketDAO bucketDAO) {
        this.recipeManager = recipeManager;
        this.reagentManager = reagentManager;
        this.bucketDAO = bucketDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRecipesPage(ModelAndView modelAndView) {
        modelAndView.addObject("allRecipes", recipeManager.findAll());
        modelAndView.setViewName("recipesPage");
        return modelAndView;
    }

    @RequestMapping(path = "add", method = RequestMethod.GET)
    public ModelAndView showNewRecipePage(ModelAndView modelAndView, RecipeForm recipeForm) {
        modelAndView.addObject("recipeForm", recipeForm);
        modelAndView.addObject("allReagents", reagentManager.findAll());
        modelAndView.setViewName("newRecipePage");
        return modelAndView;
    }

    @RequestMapping(path = "add", method = RequestMethod.POST)
    public ModelAndView submitNewRecipe(@ModelAttribute("recipeForm") @Valid RecipeForm recipeForm, BindingResult result,
                                        ModelAndView modelAndView) {
        if (result.hasErrors()) {
            modelAndView.addObject("allReagents", reagentManager.findAll());
            modelAndView.setViewName("newRecipePage");
            return modelAndView;
        }
        checkName(recipeForm.getName());
        recipeManager.merge(RecipeInfoModel.fromForm(recipeForm, reagentManager.findAll()));
        reagentManager.merge(ReagentInfoModel.fromForm(new ReagentForm(recipeForm.getId(), recipeForm.getName(),
                recipeForm.getSellPrice())));
        modelAndView.setViewName("redirect:/recipes");
        return modelAndView;
    }

    @RequestMapping(value = "recipe", method = RequestMethod.GET)
    public ModelAndView getRecipeById(@RequestParam int id, ModelAndView model) {
        model.addObject("recipe", recipeManager.findById(id));
        model.setViewName("recipeById");
        return model;
    }

    @RequestMapping(path = "edit", method = RequestMethod.GET)
    public ModelAndView editRecipePage(@RequestParam Integer id, ModelAndView modelAndView) {
        if (!recipeManager.exist(id)) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        modelAndView.addObject("recipeForm", RecipeForm.fromModel(recipeManager.findById(id)));
        modelAndView.addObject("allReagents", reagentManager.findAll());
        modelAndView.setViewName("editRecipePage");
        return modelAndView;
    }

    @RequestMapping(path = "edit", method = RequestMethod.POST)
    public ModelAndView editRecipe(@ModelAttribute("recipeForm") @Valid RecipeForm recipeForm,
                                   BindingResult result, ModelAndView modelAndView) {
        if (result.hasErrors()) {
            modelAndView.addObject("allReagents", reagentManager.findAll());
            modelAndView.setViewName("editRecipePage");
            return modelAndView;
        }
        checkName(recipeForm.getName());
        recipeManager.merge(RecipeInfoModel.fromForm(recipeForm, reagentManager.findAll()));
        return new ModelAndView("redirect:/recipes");
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public ModelAndView deleteReagent(@RequestParam Integer id) {
        if (!recipeManager.exist(id)) {
            return new ModelAndView("redirect:/");
        }
        recipeManager.delete(recipeManager.findById(id));
        return new ModelAndView("redirect:/recipes");
    }

    @RequestMapping(value = "craft_from_stock", method = RequestMethod.GET)
    public ModelAndView craftFromStock(@RequestParam Integer id) {
        if (!recipeManager.exist(id)) {
            return new ModelAndView("redirect:/");
        }
        CraftStock craftStock = bucketDAO.getStock();
        StockManager stockManager = new StockManager(bucketDAO.getStock());
        RecipeInfoModel recipeModel = recipeManager.findById(id);
        ReagentInfoModel itemModel = reagentManager.findByName(recipeModel.getName());
        Map<Integer, Integer> mapForCraft = findCraftMap(recipeModel);
        BigDecimal craftPrice = stockManager.calculateCraftPrice(mapForCraft,craftStock);
        stockManager.withdraw(mapForCraft,craftStock);
        stockManager.deposit(itemModel.getId(),craftPrice, craftStock);
        bucketDAO.saveStock(craftStock);
        return new ModelAndView("redirect:/stock");
    }

    private Map<Integer,Integer> findCraftMap(RecipeInfoModel recipeModel) {
        Map<Integer, Integer> craftMap = new HashMap<>();
        for (Map.Entry<ReagentInfoModel,Integer> modelMap: recipeModel.getReagenCountMap().entrySet()) {
            craftMap.put(modelMap.getKey().getId(), modelMap.getValue());
        }
        return craftMap;
    }

    private boolean checkName(String name) {
        if (recipeManager.existByName(name)) {
            throw new RuntimeException("Name already used");
        }
        return false;
    }
}
