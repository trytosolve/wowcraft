package com.iredko.wowcraft2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class HomePageController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showMainPage(ModelAndView modelAndView) {
        modelAndView.setViewName("homePage");
        return modelAndView;
    }
}
