package com.iredko.wowcraft2.controllers.stock;

import com.iredko.wowcraft2.service.StockBrunchManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/stock")
public class StockController {

    private StockBrunchManager stockBrunchManager;

    public StockController(StockBrunchManager stockBrunchManager) {
        this.stockBrunchManager = stockBrunchManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showStock(ModelAndView modelAndView) {
        modelAndView.addObject("allStockBranches",stockBrunchManager.findAll());
        modelAndView.setViewName("stockPage");
        return modelAndView;
    }
}
