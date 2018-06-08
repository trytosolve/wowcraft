package com.iredko.wowcraft.controllers.reagent;

import com.iredko.wowcraft.DAO.reagent.Reagent;
import com.iredko.wowcraft.service.ReagentManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/reagents")
public class ReagentController {

    private ReagentManager reagentManager;

    public ReagentController(ReagentManager reagentManager) {
        this.reagentManager = reagentManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showReagentPage(ModelAndView model) {
        List<ReagentModel> reagentModelList = new ArrayList<>();
        for (Reagent reagent : reagentManager.findAll()) {
            ReagentModel reagentModel = new ReagentModel(reagent);
            reagentModelList.add(reagentModel);
        }
        model.addObject("allReagents", reagentModelList);
        model.setViewName("reagentPage");
        return model;
    }

    @RequestMapping(path = "add",method = RequestMethod.GET)
    public ModelAndView showAddReagentPage(ModelAndView modelAndView, ReagentForm reagentForm) {
        modelAndView.addObject("reagentForm", reagentForm);
        modelAndView.setViewName("addReagentPage");
        return modelAndView;
    }

    @RequestMapping(path = "add",method = RequestMethod.POST)
    public ModelAndView addReagent(@ModelAttribute("reagentForm") @Valid ReagentForm reagentForm,
                                   BindingResult result, ModelAndView modelAndView) {
        if (result.hasErrors()) {
            modelAndView.setViewName("addReagentPage");
            return modelAndView;
        }
        reagentManager.addReagent(reagentForm.getName(),reagentForm.getItemLvl(),reagentForm.getMaxStack(),reagentForm.getSellPrice());
        return new ModelAndView("redirect:/reagents");
    }

    @RequestMapping (value = "delete", method = RequestMethod.GET)
    public ModelAndView deleteReagent(@RequestParam("id") Integer id) {
        reagentManager.delete(reagentManager.findById(id));
        return new ModelAndView("redirect:/reagents");
    }

    @RequestMapping (value = "edit", method = RequestMethod.GET)
    public ModelAndView showEditReagentPage(@RequestParam("id") Integer id, ModelAndView modelAndView) {
        Reagent reagent = reagentManager.findById(id);
        ReagentForm reagentForm = new ReagentForm(reagent);
        modelAndView.addObject("reagentForm",reagentForm);
        modelAndView.setViewName("editReagentPage");
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelAndView editReagent(@ModelAttribute("reagentForm") @Valid ReagentForm reagentForm,
                                    BindingResult result,@RequestParam Integer id, ModelAndView modelAndView) {
        if (result.hasErrors()) {
            modelAndView.setViewName("editReagentPage");
            return modelAndView;
        }
        Reagent editRegent = new Reagent(reagentForm.getName(),reagentForm.getItemLvl(),reagentForm.getItemLvl(),
                reagentForm.getSellPrice());
        editRegent.setId(reagentForm.getId());
        reagentManager.update(editRegent);
        return new ModelAndView("redirect:/reagents");
    }
}
