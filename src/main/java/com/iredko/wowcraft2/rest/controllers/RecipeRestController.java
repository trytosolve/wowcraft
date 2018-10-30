package com.iredko.wowcraft2.rest.controllers;


import com.iredko.wowcraft2.controllers.recipe.RecipeInfoModel;
import com.iredko.wowcraft2.rest.components.RecipeToView;
import com.iredko.wowcraft2.service.ReagentManager;
import com.iredko.wowcraft2.service.RecipeManager;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<RecipeToView> getRecipes() {
        return RecipeToView.transformListToView(recipeManager.findAll());
    }

    @RequestMapping(value = "/rest/recipes/add", method = RequestMethod.POST)
    public void addRecipe(@RequestBody @Valid RecipeToView recipe, BindingResult result) {
        if (result.hasErrors()) {
            throw new RuntimeException(getErrors(result));
        }
        checkName(recipe.getName());
        System.out.println(recipe);
        recipeManager.insert(RecipeToView.transformToDB(recipe));
    }

    @RequestMapping(value = "/rest/recipe", method = RequestMethod.GET)
    private RecipeToView getRecipeById(@RequestParam("id") Integer id) {
        if (!recipeManager.exist(id)) {
            throw new RuntimeException("No such object in DB");
        }
        return RecipeToView.transformToView(recipeManager.findById(id));
    }

    @RequestMapping(path = "/rest/recipes/delete", method = RequestMethod.GET)
    public void deleteRecipe(@RequestParam("id") Integer id) {
        if (!recipeManager.exist(id)) {
            throw new RuntimeException("No such object in DB");
        }
        RecipeInfoModel recipe = recipeManager.findById(id);
        recipeManager.delete(recipe);
    }

    private boolean checkName(String name) {
        if (recipeManager.existByName(name)) {
            throw new RuntimeException("Name already used");
        }
        return false;
    }

    private String getErrors(BindingResult result) {
        StringBuilder message = new StringBuilder();
        for (Object object : result.getAllErrors()) {
            if(object instanceof FieldError) {
                FieldError fieldError = (FieldError) object;
                message.append(fieldError.getCode() + " : " + fieldError.getObjectName() +
                        " - "+fieldError.getDefaultMessage()+ "; ");
            }
        }
        return message.toString();
    }

}
