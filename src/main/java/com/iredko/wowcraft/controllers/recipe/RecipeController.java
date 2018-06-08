package com.iredko.wowcraft.controllers.recipe;


import com.iredko.wowcraft.DAO.reagent.Reagent;
import com.iredko.wowcraft.DAO.recipe.Recipe;
import com.iredko.wowcraft.service.ReagentManager;
import com.iredko.wowcraft.service.RecipeManager;
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
        model.addObject("allRecipes", recipeManager.findAll());
        model.setViewName("recipePage");
        return model;
    }

    @RequestMapping(path = "add",method = RequestMethod.GET)
    public ModelAndView showAddReagentPage(ModelAndView modelAndView, RecipeForm recipeForm) {
        modelAndView.addObject("recipeFrom", recipeForm);
        recipeForm.setAllReagentList(reagentManager.findAll());
        modelAndView.setViewName("addRecipePage");
        return modelAndView;
    }

    @RequestMapping(path = "add",method = RequestMethod.POST)
    public ModelAndView addRecipe(@ModelAttribute("recipeForm") @Valid RecipeForm recipeForm,
                                   BindingResult result, ModelAndView modelAndView) {
        recipeForm.setAllReagentList(reagentManager.findAll());
        if (result.hasErrors()) {
            modelAndView.setViewName("addRecipePage");
            return modelAndView;
        }
        for (Map.Entry<Integer, Integer> entry : recipeForm.getReagentCountMap().entrySet()) {
            if (entry.getKey()==null || entry.getValue()==null) {
                modelAndView.addObject("optionError", "Set name and quantity for all reagents!");
                modelAndView.setViewName("addRecipePage");
                return modelAndView;
            }
        }
        recipeManager.addRecipe(recipeForm.getName(),recipeForm.getReagentCountMap());
        return new ModelAndView("redirect:/recipes");
    }


    @RequestMapping(value = "recipe",method = RequestMethod.GET)
    public ModelAndView getRecipeById(@RequestParam int id, ModelAndView model) {
        model.addObject("recipe", recipeManager.findById(id));
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
            modelAndView.setViewName("editRecipePage");
            return modelAndView;
        }
        recipeForm.setId(id);
        recipeManager.saveChanges(id,recipeForm.getName(),recipeForm.getReagentCountMap());
//        Recipe recipe = recipeManager.findById(id);
//        recipe.getReagents().clear();
//        Map<Integer,Integer> reagentDetailsMap = recipeForm.getReagentCountMap();
//        for (Map.Entry<Integer, Integer> entry : reagentDetailsMap.entrySet()) {
//            recipe.addReagent(reagentManager.findById(entry.getKey()),entry.getValue());
//        }
//        recipe.setName(recipeForm.getName());
//        recipeManager.update(recipe);
        return new ModelAndView("redirect:/recipes");
    }

    @RequestMapping (value = "delete", method = RequestMethod.GET)
    public ModelAndView deleteReagent(@RequestParam Integer id) {
        recipeManager.delete(recipeManager.findById(id));
        return new ModelAndView("redirect:/recipes");
    }
}
