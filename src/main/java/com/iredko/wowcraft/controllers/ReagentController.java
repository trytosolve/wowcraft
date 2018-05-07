package com.iredko.wowcraft.controllers;

import com.iredko.wowcraft.entities.Reagent;
import com.iredko.wowcraft.impl.ReagentManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
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
}
