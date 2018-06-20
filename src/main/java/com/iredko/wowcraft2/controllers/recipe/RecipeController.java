package com.iredko.wowcraft2.controllers.recipe;

import com.iredko.wowcraft2.DAO.recipe.Recipe;
import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;
import com.iredko.wowcraft2.service.ReagentManager;
import com.iredko.wowcraft2.service.RecipeManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/recipes")
public class RecipeController {

    RecipeManager recipeManager;
    ReagentManager reagentManager;

    public RecipeController(RecipeManager recipeManager, ReagentManager reagentManager) {
        this.recipeManager = recipeManager;
        this.reagentManager = reagentManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRecipesPage(ModelAndView modelAndView) {
        modelAndView.addObject("allRecipes",recipeManager.findAll());
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
        recipeManager.merge(RecipeInfoModel.fromForm(recipeForm,reagentManager.findAll()));
        modelAndView.setViewName("redirect:/recipes");
        return modelAndView;
    }

    @RequestMapping(value = "recipe",method = RequestMethod.GET)
    public ModelAndView getRecipeById(@RequestParam int id, ModelAndView model) {
        model.addObject("recipe", recipeManager.findById(id));
        model.setViewName("recipeById");
        return model;
    }

    @RequestMapping(path = "edit",method = RequestMethod.GET)
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

    @RequestMapping(path = "edit",method = RequestMethod.POST)
    public ModelAndView editRecipe(@ModelAttribute("recipeForm") @Valid RecipeForm recipeForm,
                                   BindingResult result,ModelAndView modelAndView) {
        if (result.hasErrors()) {
            modelAndView.addObject("allReagents", reagentManager.findAll());
            modelAndView.setViewName("editRecipePage");
            return modelAndView;
        }
        recipeManager.merge(RecipeInfoModel.fromForm(recipeForm,reagentManager.findAll()));
        return new ModelAndView("redirect:/recipes");
    }

    @RequestMapping (value = "delete", method = RequestMethod.GET)
    public ModelAndView deleteReagent(@RequestParam Integer id) {
        if (!recipeManager.exist(id)) {
            return new ModelAndView("redirect:/");
        }
        recipeManager.delete(recipeManager.findById(id));
        return new ModelAndView("redirect:/recipes");
    }
}
