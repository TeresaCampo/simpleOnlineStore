package com.elaborato.simpleOnlineStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController {
    @GetMapping("/adminLogin/")
    public String home() {
        return "adminLogin";}
}

