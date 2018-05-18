package com.iredko.wowcraft.controllers;


import com.iredko.wowcraft.entities.Reagent;
import com.iredko.wowcraft.entities.Recipe;
import com.iredko.wowcraft.entities.RecipeReagent;
import com.iredko.wowcraft.models.RecipeForm;
import com.iredko.wowcraft.impl.ReagentManager;
import com.iredko.wowcraft.impl.RecipeManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
        List<Reagent> reagents = reagentManager.findAll();
        recipeForm.setAllReagentList(reagents);
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
        Map<Integer,Integer> reagentDetailsMap = recipeForm.getReagentCountMap();
        Recipe recipe = new Recipe(recipeForm.getName());
        for (Map.Entry<Integer, Integer> entry : reagentDetailsMap.entrySet()) {
            recipe.addReagent(reagentManager.findById(entry.getKey()),entry.getValue());
        }
        recipeManager.update(recipe);
        return new ModelAndView("redirect:"+"/recipes");
    }


    @RequestMapping(value = "recipe",method = RequestMethod.GET)
    public ModelAndView getRecipeById(@RequestParam int id, ModelAndView model) {
        Recipe recipe = recipeManager.findById(id);
        model.addObject("recipe", recipe);
        model.setViewName("recipeById");
        return model;
    }

    @RequestMapping(path = "edit",method = RequestMethod.GET)
    public ModelAndView editReagent(@RequestParam int id, ModelAndView modelAndView) {
        Recipe recipe = recipeManager.findById(id);
        List<Reagent> reagents = reagentManager.findAll();
        RecipeForm recipeForm = new RecipeForm(recipe, reagents);
        modelAndView.addObject("recipeForm", recipeForm);
        modelAndView.setViewName("editRecipePage");
        return modelAndView;
    }

    @RequestMapping(path = "edit", method = RequestMethod.POST)
    public ModelAndView saveEditReagent(@RequestParam int id,@ModelAttribute("recipeForm")
    @Valid RecipeForm recipeForm, BindingResult result, ModelAndView modelAndView) {
        if (result.hasErrors()) {
            modelAndView.setViewName("editReagentPage");
            return modelAndView;
        }
        recipeForm.setId(id);
        Recipe recipe = recipeManager.findById(id);
//        for (RecipeReagent recipeReagent : recipe.getReagents()) {
//            recipe.removeReagent(recipeReagent.getReagent());
//        }
        recipe.getReagents().clear();
        Map<Integer,Integer> reagentDetailsMap = recipeForm.getReagentCountMap();
        for (Map.Entry<Integer, Integer> entry : reagentDetailsMap.entrySet()) {
            recipe.addReagent(reagentManager.findById(entry.getKey()),entry.getValue());
        }
        recipeManager.update(recipe);
        return new ModelAndView("redirect:"+"/recipes");
    }

    @RequestMapping (value = "delete", method = RequestMethod.GET)
    public ModelAndView deleteReagent(@RequestParam Integer id) {
        recipeManager.delete(recipeManager.findById(id));
        return new ModelAndView("redirect:"+"/recipes");
    }
}
