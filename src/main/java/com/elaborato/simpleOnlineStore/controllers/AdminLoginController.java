package com.elaborato.simpleOnlineStore.controllers;

import com.elaborato.simpleOnlineStore.services.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminLoginController {

    SecurityService securityService;
    public AdminLoginController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/adminLogin")
    public String adminLogin(@RequestParam(value = "error", required = false) boolean error, Model model) {
        model.addAttribute("authenticatedUser", securityService.getAuthenticatedUserName());

        if (error) {
            model.addAttribute("loginError", true);
        }
        return "adminLogin";
    }
}

