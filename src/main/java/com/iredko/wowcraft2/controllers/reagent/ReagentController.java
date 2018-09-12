package com.iredko.wowcraft2.controllers.reagent;

import com.iredko.wowcraft2.controllers.recipe.RecipeInfoModel;
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
@RequestMapping(path = "/reagents")
public class ReagentController {

    private ReagentManager reagentManager;
    private RecipeManager recipeManager;

    public ReagentController(ReagentManager reagentManager, RecipeManager recipeManager) {
        this.reagentManager = reagentManager;
        this.recipeManager = recipeManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showReagentPage(ModelAndView model) {
        model.addObject("allReagents", reagentManager.findAll());
        model.setViewName("reagentsPage");
        return model;
    }

    @RequestMapping(path = "add",method = RequestMethod.GET)
    public ModelAndView showNewReagentPage(ModelAndView modelAndView, ReagentForm reagentForm) {
        modelAndView.addObject("reagentForm", reagentForm);
        modelAndView.setViewName("newReagentPage");
        return modelAndView;
    }

    @RequestMapping(path = "add", method = RequestMethod.POST)
    public ModelAndView submitNewReagent(@ModelAttribute("reagentForm") @Valid ReagentForm reagentForm,
                                         BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("newReagentPage");
        }
        checkName(reagentForm.getName());
        reagentManager.insert(ReagentInfoModel.fromForm(reagentForm));
        return new ModelAndView("redirect:/reagents");
    }

    @RequestMapping(path = "delete", method = RequestMethod.GET)
    public ModelAndView deleteReagent(@RequestParam("id") Integer id,ModelAndView modelAndView) {
        if (!reagentManager.exist(id)) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        ReagentInfoModel reagent = reagentManager.findById(id);
        modelAndView.setViewName("reagentsPage");
        if (checkUsages(reagent, modelAndView)) {
            modelAndView.addObject("allReagents", reagentManager.findAll());
            return modelAndView;
        }
        reagentManager.delete(reagent);
        modelAndView.addObject("allReagents", reagentManager.findAll());
        return modelAndView;
    }

    @RequestMapping(path = "edit", method = RequestMethod.GET)
    public ModelAndView showEditReagentPage(@RequestParam("id") Integer id, ModelAndView modelAndView) {
        if (!reagentManager.exist(id)) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        modelAndView.addObject(ReagentForm.fromModel(reagentManager.findById(id)));
        modelAndView.setViewName("editReagentPage");
        return modelAndView;
    }

    @RequestMapping(path = "edit", method = RequestMethod.POST)
    public ModelAndView editReagent(@ModelAttribute("reagentForm") @Valid ReagentForm reagentForm,
                                    BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("editReagentPage");
        }
        checkName(reagentForm.getName());
        reagentManager.merge(ReagentInfoModel.fromForm(reagentForm));
        return new ModelAndView("redirect:/reagents");
    }

    private boolean checkUsages(ReagentInfoModel reagent,ModelAndView modelAndView) {
        List<RecipeInfoModel> usageList = recipeManager.findByReagent(reagent);
        if (usageList.size() != 0) {
            modelAndView.addObject("usageError", "This reagent has some usages.Before deleting you must" +
                    " change next recipes: ");
            modelAndView.addObject("usagesList", usageList);
            return true;
        }
        if (recipeManager.existByName(reagent.getName())) {
            throw new RuntimeException("This reagent can craft by recipe, delete recipe before reagent");
        }
        return false;
    }

    private boolean checkName(String name) {
        if (reagentManager.existByName(name)) {
            throw new RuntimeException("Name already used");
        }
        return false;
    }
}
