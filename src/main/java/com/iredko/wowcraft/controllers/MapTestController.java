package com.iredko.wowcraft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("map_test")
public class MapTestController {
    @GetMapping
    public String welcomePage(Model model) {
        model.addAttribute("testMap", new MapHolder());
        return "mapTest";
    }
    @PostMapping
    public ModelAndView testMethod(@ModelAttribute("testMap") MapHolder mapHolder) {
        return new ModelAndView("mapTest");
    }

    public static class MapHolder {
        private Map<String, String> map = new HashMap<>();
        {
            map.put("testKey1", "testVal1");
            map.put("testKey2", "val2");
        }

        public Map<String, String> getMap() {
            return map;
        }

        public void setMap(Map<String, String> map) {
            this.map = map;
        }
    }
}
