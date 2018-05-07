package com.iredko.wowcraft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class MainController {

    public ModelAndView showMainPage(ModelAndView modelAndView) {
        modelAndView.setViewName("mainPage");
        return modelAndView;
    }
}
