package com.elaborato.simpleOnlineStore.controllers;

import com.elaborato.simpleOnlineStore.services.ArticleService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebbugController {

    ArticleService articleService;

    public DebbugController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/auth-status")
    public String authStatus() {
       /* Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return "Authenticated: " + authentication.getName();
        } else {
            return "Not Authenticated";
        }*/
        if( articleService.articleNameIsInvalidString("   ")) return "Invalid string";
        return "Valid string";




    }
}
