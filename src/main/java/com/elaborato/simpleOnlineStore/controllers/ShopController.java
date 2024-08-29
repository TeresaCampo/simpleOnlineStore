package com.elaborato.simpleOnlineStore.controllers;

import com.elaborato.simpleOnlineStore.domain.dto.ShopArticleCard;
import com.elaborato.simpleOnlineStore.domain.dto.ShopFormDto;
import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import com.elaborato.simpleOnlineStore.domain.mappers.ShopArticleCardMapper;
import com.elaborato.simpleOnlineStore.domain.mappers.ShopFormMapper;
import com.elaborato.simpleOnlineStore.services.ArticleService;
import com.elaborato.simpleOnlineStore.services.ImageService;
import com.elaborato.simpleOnlineStore.services.SecurityService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class ShopController {
    private ArticleService articleService;
    private ImageService imageService;
    SecurityService securityService;
    ShopFormMapper shopFormMapper;
    ShopArticleCardMapper shopArticleCardMapper;


    public ShopController(ArticleService articleService, ImageService imageService, SecurityService securityService, ShopFormMapper shopFormMapper, ShopArticleCardMapper shopArticleCardMapper) {
        this.articleService = articleService;
        this.imageService = imageService;
        this.securityService = securityService;
        this.shopFormMapper = shopFormMapper;
        this.shopArticleCardMapper = shopArticleCardMapper;
    }

    @GetMapping("/shop")
    public String getArticles(Model model) {
        model.addAttribute("authenticatedUser", securityService.getAuthenticatedUserName());
        model.addAttribute("shopFormDto", new ShopFormDto());


        List<ShopArticleCard> articles = articleService.findAll().stream()
                .map(articleEntity -> shopArticleCardMapper.toShopArticleCard(articleEntity))
                .collect(Collectors.toList());
        model.addAttribute("articlesCards", articles);
        return "shop";
    }

    @PostMapping("/shop/upload")
    public String uploadArticle(@Valid @ModelAttribute("shopFormDto") ShopFormDto shopFormDto,
                                BindingResult bindingResult,
                                Model model){
        // Check for validation errors
        boolean articleAlreadyExists=articleService.articleNameInUse(shopFormDto.getName());
        model.addAttribute("articleAlreadyExists", articleAlreadyExists);
        if( articleAlreadyExists){
            shopFormDto.setName(null);
        }
        if (bindingResult.hasErrors() || articleAlreadyExists ) {
            model.addAttribute("authenticatedUser", securityService.getAuthenticatedUserName());

            List<ShopArticleCard> articles = articleService.findAll().stream()
                    .map(articleEntity -> shopArticleCardMapper.toShopArticleCard(articleEntity))
                    .collect(Collectors.toList());
            model.addAttribute("articlesCards", articles);
            return "shop";
        }
        //If there are no validation errors
        if(articleService.articleNameInUse(shopFormDto.getName())){

        }

        ImageEntity imageEntity=imageService.createImageFilesystem(shopFormDto);

        ArticleEntity articleEntity= shopFormMapper.toArticleEntity(shopFormDto);
        articleEntity.setImage(imageEntity);
        articleService.createArticleSQL(articleEntity);

        return "redirect:/shop";
    }

    @ExceptionHandler(RuntimeException.class)

    public String handleRuntimeException(RuntimeException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";  // Nome della pagina di errore
    }
}
