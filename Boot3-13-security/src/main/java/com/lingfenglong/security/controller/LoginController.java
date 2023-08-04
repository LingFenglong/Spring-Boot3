package com.lingfenglong.security.controller;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@EnableMethodSecurity
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
