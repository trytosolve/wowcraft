package com.iredko.wowcraft2.rest.controllers;


import com.iredko.wowcraft2.controllers.recipe.RecipeInfoModel;
import com.iredko.wowcraft2.service.ReagentManager;
import com.iredko.wowcraft2.service.RecipeManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class RecipeRestController {

    private ReagentManager reagentManager;
    private RecipeManager recipeManager;

    public RecipeRestController(ReagentManager reagentManager, RecipeManager recipeManager) {
        this.reagentManager = reagentManager;
        this.recipeManager = recipeManager;
    }

    @RequestMapping(path = "/rest/recipes", method = RequestMethod.GET)
    public List<RecipeInfoModel> getRecipes() {
        return recipeManager.findAll();
    }
}
