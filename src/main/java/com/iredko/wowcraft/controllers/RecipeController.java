package com.iredko.wowcraft.controllers;


import com.iredko.wowcraft.entities.Reagent;
import com.iredko.wowcraft.entities.Recipe;
import com.iredko.wowcraft.entities.RecipeReagent;
import com.iredko.wowcraft.impl.RecipeManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/recipes")
public class RecipeController {

    private RecipeManager recipeManager;

    public RecipeController(RecipeManager reagentManager) {

        this.recipeManager = reagentManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showReagentPage(ModelAndView model) {
        List<Recipe> recipes = recipeManager.findAll();
        model.addObject("allRecipes", recipes);
        model.setViewName("recipePage");
        return model;
    }

    @RequestMapping(path = "add_new_recipe",method = RequestMethod.GET)
    public ModelAndView showAddReagentPage(ModelAndView modelAndView) {
        modelAndView.setViewName("mainPage");
        return modelAndView;
    }

    @RequestMapping(value="id{id}",method = RequestMethod.GET)
    public ModelAndView getNews(@PathVariable int id, ModelAndView model) {
        Recipe recipe = recipeManager.findById(id);
        model.addObject("recipe", recipe);
        model.setViewName("recipeById");
        return model;
    }

    @RequestMapping (value = "del{id}", method = RequestMethod.GET)
    public ModelAndView deleteReagent(@PathVariable Integer id, ModelAndView modelAndView) {
        recipeManager.delete(recipeManager.findById(id));
        return new ModelAndView("redirect:"+"/recipes");
    }
}
