package com.lingfenglong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String welcome(@RequestParam(value = "name", defaultValue = "") String name,
                          Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }
}
