package com.iredko.wowcraft2.rest.controllers;


import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;
import com.iredko.wowcraft2.controllers.recipe.RecipeInfoModel;
import com.iredko.wowcraft2.service.ReagentManager;
import com.iredko.wowcraft2.service.RecipeManager;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class ReagentRestController {

    private ReagentManager reagentManager;
    private RecipeManager recipeManager;

    public ReagentRestController(ReagentManager reagentManager, RecipeManager recipeManager) {
        this.reagentManager = reagentManager;
        this.recipeManager = recipeManager;
    }

    @RequestMapping(value = "/rest/reagents", method = RequestMethod.GET)
    public List<ReagentInfoModel> getReagents() {
        return reagentManager.findAll();
    }

    @RequestMapping(value = "/rest/reagent", method = RequestMethod.GET)
    private ReagentInfoModel getReagentById(@RequestParam("id") Integer id) {
        if (!reagentManager.exist(id)) {
            throw new RuntimeException("No such object in DB");
        }
        return reagentManager.findById(id);
    }

    @RequestMapping(value = "/rest/reagents/add", method = RequestMethod.POST)
    public void addReagent(@RequestBody @Valid ReagentInfoModel reagentInfoModel, BindingResult result) {
        if (result.hasErrors()) {
            throw new RuntimeException(getErrors(result));
        }
        checkName(reagentInfoModel.getName());
        reagentManager.insert(reagentInfoModel);
    }


    @RequestMapping(value = "/rest/reagents/edit", method = RequestMethod.POST)
    public void editReagent(@RequestBody @Valid ReagentInfoModel reagentInfoModel, BindingResult result) {
        if (result.hasErrors()) {
            throw new RuntimeException(getErrors(result));
        }
        checkName(reagentInfoModel.getName());
        reagentManager.merge(reagentInfoModel);
    }

    @RequestMapping(path = "/rest/reagents/delete", method = RequestMethod.GET)
    public void deleteReagent(@RequestParam("id") Integer id) {
        if (!reagentManager.exist(id)) {
            throw new RuntimeException("No such object in DB");
        }
        ReagentInfoModel reagent = reagentManager.findById(id);
        checkUsages(reagent);
        reagentManager.delete(reagent);
    }

    private void checkUsages(ReagentInfoModel reagent) {
        List<RecipeInfoModel> usageList = recipeManager.findByReagent(reagent);
        if (usageList.size() != 0) {
            StringBuilder usageNames = new StringBuilder();
            for (RecipeInfoModel recipe : usageList) {
                usageNames.append(recipe.getName() + "; ");
            }
            throw new RuntimeException("This reagent has some usages.Before deleting you must" +
                    " change next recipes: " + usageNames);
        }
        if (recipeManager.existByName(reagent.getName())) {
            throw new RuntimeException("This reagent can craft by recipe, delete recipe before reagent");
        }
    }

    private boolean checkName(String name) {
        if (reagentManager.existByName(name)) {
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
