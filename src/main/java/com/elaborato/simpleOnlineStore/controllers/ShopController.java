package com.elaborato.simpleOnlineStore.controllers;

import com.elaborato.simpleOnlineStore.domain.dto.ArticleDto;
import com.elaborato.simpleOnlineStore.services.ArticleService;
import com.elaborato.simpleOnlineStore.services.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShopController {
    private ArticleService articleService;
    SecurityService securityService;


    public ShopController(ArticleService articleService, SecurityService securityService) {
        this.articleService = articleService;
        this.securityService = securityService;
    }

    @GetMapping("/shop")
    public String getArticles(Model model) {
        model.addAttribute("authenticatedUser", securityService.getAuthenticatedUserName());

        List<ArticleDto> articles = articleService.findAll();
        model.addAttribute("articles", articles); // Add articles to the model
        return "shop";
    }
}
