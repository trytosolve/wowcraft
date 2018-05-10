package com.iredko.wowcraft.controllers;

import com.iredko.wowcraft.entities.Reagent;
import com.iredko.wowcraft.entities.ReagentForm;
import com.iredko.wowcraft.impl.ReagentManager;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
        List<Reagent> reagents = reagentManager.findAll();
        model.addObject("allReagents", reagents);
        model.setViewName("reagentPage");
        return model;
    }

    @RequestMapping (value = "del{id}", method = RequestMethod.GET)
    public ModelAndView deleteReagent(@PathVariable Integer id,ModelAndView modelAndView) {
        reagentManager.delete(reagentManager.findById(id));
        return new ModelAndView("redirect:"+"/reagents");
    }
}
