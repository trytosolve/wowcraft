package com.iredko.wowcraft.controllers;


import com.iredko.wowcraft.entities.Reagent;
import com.iredko.wowcraft.entities.Recipe;
import com.iredko.wowcraft.models.RecipeForm;
import com.iredko.wowcraft.impl.ReagentManager;
import com.iredko.wowcraft.impl.RecipeManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/recipes")
public class RecipeController {

    private RecipeManager recipeManager;
    private ReagentManager reagentManager;

    public RecipeController(RecipeManager recipeManager, ReagentManager reagentManager) {
        this.recipeManager = recipeManager;
        this.reagentManager = reagentManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showReagentPage(ModelAndView model) {
        List<Recipe> recipes = recipeManager.findAll();
        model.addObject("allRecipes", recipes);
        model.setViewName("recipePage");
        return model;
    }

    @RequestMapping(path = "add",method = RequestMethod.GET)
    public ModelAndView showAddReagentPage(ModelAndView modelAndView, RecipeForm recipeForm) {
        modelAndView.addObject("recipeFrom", recipeForm);
        List<Reagent> recipes = reagentManager.findAll();
        recipeForm.setReagentList(recipes);
        modelAndView.setViewName("addRecipePage");
        return modelAndView;
    }

    @RequestMapping(path = "add",method = RequestMethod.POST)
    public ModelAndView addReagent(@ModelAttribute("recipeForm") @Valid RecipeForm recipeForm,
                                   BindingResult result, ModelAndView modelAndView) {
        if (result.hasErrors()) {
            modelAndView.setViewName("addRecipePage");
            return modelAndView;
        }
//        reagentManager.insert(new Reagent(reagentForm.getName(),reagentForm.getItemLvl(),reagentForm.getItemLvl(),
//                reagentForm.getCellPrice()));
        return new ModelAndView("redirect:"+"/reagents");
    }


    @RequestMapping(value = "recipe",method = RequestMethod.GET)
    public ModelAndView getRecipeById(@RequestParam int id, ModelAndView model) {
        Recipe recipe = recipeManager.findById(id);
        model.addObject("recipe", recipe);
        model.setViewName("recipeById");
        return model;
    }

    @RequestMapping (value = "delete", method = RequestMethod.GET)
    public ModelAndView deleteReagent(@RequestParam Integer id) {
        recipeManager.delete(recipeManager.findById(id));
        return new ModelAndView("redirect:"+"/recipes");
    }
}
