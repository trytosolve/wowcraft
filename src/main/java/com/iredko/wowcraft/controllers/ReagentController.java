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

    //TODO если ты посмотришь на урл который выходит - /reagents/add_new_reagent. В самом начале уже написано что это про реагенты. Не надо 2й раз писать что это реагенты)
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

    //TODO: то есть url на удаление будет del13, что странно. Обычно делается либо delete?id=13 либо delete/13
    @RequestMapping (value = "del{id}", method = RequestMethod.GET)
    public ModelAndView deleteReagent(@PathVariable Integer id,ModelAndView modelAndView) {
        reagentManager.delete(reagentManager.findById(id));
        return new ModelAndView("redirect:"+"/reagents");
    }

    //TODO аналогично - странный урл
    @RequestMapping (value = "edit{id}", method = RequestMethod.GET)
    public ModelAndView showEditReagentPage(@PathVariable Integer id,ModelAndView modelAndView,ReagentForm reagentForm) {
        Reagent reagent = reagentManager.findById(id);
        //TODO я бы сделал просто отдельный конструктор, собирающий форму из ентити. Типа new ReagentForm(entity);
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
            modelAndView.setViewName("addReagentPage"); // todo почему add?
            return modelAndView;
        }
        Reagent editRegent = new Reagent(reagentForm.getName(),reagentForm.getItemLvl(),reagentForm.getItemLvl(),
                reagentForm.getCellPrice());
        editRegent.setId(reagentForm.getId());
        reagentManager.update(editRegent);
        return new ModelAndView("redirect:"+"/reagents");
    }
}
