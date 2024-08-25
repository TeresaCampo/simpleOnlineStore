package com.elaborato.simpleOnlineStore.controllers;

import com.elaborato.simpleOnlineStore.domain.dto.ArticleDto;
import com.elaborato.simpleOnlineStore.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShopController {
    private ArticleService articleService;

    public ShopController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String getArticles(Model model) {
        List<ArticleDto> articles = articleService.findAll();
        model.addAttribute("articles", articles); // Add articles to the model
        return "shop";
    }
}
