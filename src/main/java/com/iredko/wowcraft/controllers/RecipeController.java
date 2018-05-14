package com.iredko.wowcraft.controllers;


import com.iredko.wowcraft.entities.Recipe;
import com.iredko.wowcraft.entities.Recipe;
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

    @RequestMapping(path = "add_new_recipe",method = RequestMethod.GET)
    public ModelAndView showAddReagentPage(ModelAndView modelAndView, RecipeForm recipeForm) {
        modelAndView.addObject("recipeFrom", recipeForm);
        List<Reagent> recipes = reagentManager.findAll();
        recipeForm.setReagentList(recipes);
        modelAndView.setViewName("addRecipePage");
        return modelAndView;
    }

    @RequestMapping(path = "add_new_recipe",method = RequestMethod.POST)
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


    @RequestMapping(value="id{id}",method = RequestMethod.GET)
    public ModelAndView getNews(@PathVariable int id, ModelAndView model) { //TODO getNews??? :D
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
