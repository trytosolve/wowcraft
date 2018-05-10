package com.iredko.wowcraft.controllers;

import com.iredko.wowcraft.entities.Reagent;
import com.iredko.wowcraft.entities.ReagentForm;
import com.iredko.wowcraft.impl.ReagentManager;
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

    @RequestMapping(path = "add_new_reagent",method = RequestMethod.GET)
    public ModelAndView showAddReagentPage(ModelAndView modelAndView, ReagentForm reagentForm) {
        modelAndView.addObject("reagentForm", reagentForm);
        modelAndView.setViewName("addReagentPage");
        return modelAndView;
    }

    @RequestMapping(path = "add_new_reagent",method = RequestMethod.POST)
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

    @RequestMapping (value = "del{id}", method = RequestMethod.GET)
    public ModelAndView deleteReagent(@PathVariable Integer id,ModelAndView modelAndView) {
        reagentManager.delete(reagentManager.findById(id));
        return new ModelAndView("redirect:"+"/reagents");
    }

    @RequestMapping (value = "edit{id}", method = RequestMethod.GET)
    public ModelAndView showEditReagentPage(@PathVariable Integer id,ModelAndView modelAndView,ReagentForm reagentForm) {
        Reagent reagent = reagentManager.findById(id);
        reagentForm.setId(reagent.getId());
        reagentForm.setName(reagent.getName());
        reagentForm.setItemLvl(reagent.getItemLvl());
        reagentForm.setMaxStack(reagent.getMaxStack());
        reagentForm.setCellPrice(reagent.getCellPrice());
        modelAndView.addObject(reagentForm);
        modelAndView.setViewName("editReagentPage");
        return modelAndView;
    }

    @RequestMapping(value = "edit{id}", method = RequestMethod.POST)
    public ModelAndView editReagent(@ModelAttribute("reagentForm") @Valid ReagentForm reagentForm,
                                    BindingResult result,@PathVariable Integer id, ModelAndView modelAndView) {
        if (result.hasErrors()) {
            modelAndView.setViewName("addReagentPage");
            return modelAndView;
        }
        reagentManager.update(new Reagent(reagentForm.getName(),reagentForm.getItemLvl(),reagentForm.getItemLvl(),
                reagentForm.getCellPrice()));
        return new ModelAndView("redirect:"+"/reagents");
    }
}
