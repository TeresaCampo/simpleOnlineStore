package com.elaborato.simpleOnlineStore.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebbugController {
    @GetMapping("/auth-status")
    public String authStatus() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return "Authenticated: " + authentication.getName();
        } else {
            return "Not Authenticated";
        }
    }
}
