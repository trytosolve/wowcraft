package com.iredko.wowcraft2.controllers.lot;

import com.iredko.wowcraft2.service.LotManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/lots")
public class LotController {

    LotManager lotManager;

    public LotController(LotManager lotManager) {
        this.lotManager = lotManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllLots(ModelAndView modelAndView) {
        modelAndView.addObject("lots", lotManager.findAll());
        modelAndView.setViewName("lotsPage");
        return modelAndView;
    }


    /*
    Методы для добавления и удаление лотов добавлены для удобства заполнения таблицы лотов в свой БД.
    В реальносте предполагается что таблица лотов получается из какого либо источника.
     */
    @RequestMapping(path = "add",method = RequestMethod.GET)
    public ModelAndView showNewLotPage(ModelAndView modelAndView, LotForm lotForm) {
        modelAndView.addObject("lotForm", lotForm);
        modelAndView.setViewName("newLotPage");
        return modelAndView;
    }

    @RequestMapping(path = "add", method = RequestMethod.POST)
    public ModelAndView submitNewLot(@ModelAttribute("lotForm") @Valid LotForm lotForm,
                                         BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("newLotPage");
        }
        lotManager.insert(LotInfoModel.fromForm(lotForm));
        return new ModelAndView("redirect:/lots");
    }

    @RequestMapping(path = "delete", method = RequestMethod.GET)
    public ModelAndView deleteLot(@RequestParam("id") Integer id, ModelAndView modelAndView) {
        if (!lotManager.exist(id)) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        LotInfoModel lot = lotManager.findById(id);
        lotManager.delete(lot);
        modelAndView.setViewName("lotsPage");
        return modelAndView;
    }

}
