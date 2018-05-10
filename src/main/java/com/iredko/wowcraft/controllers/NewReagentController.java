package com.iredko.wowcraft.controllers;

import com.iredko.wowcraft.entities.Reagent;
import com.iredko.wowcraft.entities.ReagentForm;
import com.iredko.wowcraft.impl.ReagentManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("add_new_reagent")
public class NewReagentController {

    private ReagentManager reagentManager;

    public NewReagentController(ReagentManager reagentManager) {
        this.reagentManager = reagentManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAddReagentPage(ModelAndView modelAndView, ReagentForm reagentForm) {
        modelAndView.addObject("reagentForm", reagentForm);
        modelAndView.setViewName("addReagentPage");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addReagent(@ModelAttribute("reagentForm") @Valid ReagentForm reagentForm,
                                   BindingResult result, ModelAndView modelAndView) {
        if (result.hasErrors()) {
            modelAndView.setViewName("addReagentPage");
            return modelAndView;
        }
        reagentManager.insert(new Reagent(reagentForm.getName(),reagentForm.getItemLvl(),reagentForm.getItemLvl(),
                reagentForm.getCellPrice()));
        return new ModelAndView("redirect:"+"/reagents");
    }

}
