package com.iredko.wowcraft.controllers;

import com.iredko.wowcraft.entities.ReagentForm;
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
        return new ModelAndView("redirect:"+"/reagents");
    }

}
