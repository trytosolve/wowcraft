package com.iredko.wowcraft2.controllers.stock;

import com.iredko.wowcraft2.components.stock.CraftStock;
import com.iredko.wowcraft2.dao.external_stock.BucketDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/stock")
public class StockController {

    private BucketDAO bucketDAO;

    public StockController(BucketDAO bucketDAO) {
        this.bucketDAO = bucketDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showStock(ModelAndView modelAndView) {
        CraftStock craftStock = bucketDAO.getStock();
        modelAndView.addObject("leftovers",craftStock.getItemLeftovers());
        modelAndView.setViewName("stockPage");
        return modelAndView;
    }
}
