package com.elaborato.simpleOnlineStore.controllers;

import com.elaborato.simpleOnlineStore.domain.dto.ShopArticleCardDto;
import com.elaborato.simpleOnlineStore.domain.dto.ShopFormDto;
import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import com.elaborato.simpleOnlineStore.domain.mappers.ShopArticleCardMapper;
import com.elaborato.simpleOnlineStore.domain.mappers.ShopFormMapper;
import com.elaborato.simpleOnlineStore.services.ArticleService;
import com.elaborato.simpleOnlineStore.services.ImageService;
import com.elaborato.simpleOnlineStore.services.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.stream.Collectors;

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


        List<ShopArticleCardDto> articles = articleService.findAll().stream()
                .map(articleEntity -> shopArticleCardMapper.toShopArticleCard(articleEntity))
                .collect(Collectors.toList());
        model.addAttribute("articlesCards", articles);
        return "shop";
    }

    @PostMapping("/shop/upload")
    public String uploadArticle(@ModelAttribute("shopFormDto") ShopFormDto shopFormDto,
                                Model model){
        // Check for validation errors
        boolean articleAlreadyExists=articleService.articleNameInUse(shopFormDto.getName());
        model.addAttribute("articleAlreadyExists", articleAlreadyExists);

        boolean nameIsInvalidString=articleService.articleNameIsInvalidString(shopFormDto.getName());
        model.addAttribute("nameIsInvalidString", nameIsInvalidString);
        if( articleAlreadyExists ||nameIsInvalidString ){
            shopFormDto.setName(null);
        }

        boolean priceNotPositive=(shopFormDto.getPrice()<=0);
        model.addAttribute("priceNotPositive", priceNotPositive);
        if( priceNotPositive){
            shopFormDto.setPrice(null);
        }
        if (articleAlreadyExists || nameIsInvalidString ||  priceNotPositive ) {
            model.addAttribute("authenticatedUser", securityService.getAuthenticatedUserName());

            List<ShopArticleCardDto> articles = articleService.findAll().stream()
                    .map(articleEntity -> shopArticleCardMapper.toShopArticleCard(articleEntity))
                    .collect(Collectors.toList());
            model.addAttribute("articlesCards", articles);
            return "shop";
        }
        //If there are no validation errors
        ImageEntity imageEntity=imageService.createImageFilesystem(shopFormDto);

        ArticleEntity articleEntity= shopFormMapper.toArticleEntity(shopFormDto);
        articleEntity.setImage(imageEntity);
        articleService.createArticleSQL(articleEntity);

        return "redirect:/shop";
    }

    @PostMapping("/delete")
    public String deleteArticle(@RequestParam("name") String articleName) {

        ArticleEntity articleEntity=articleService.findArticleByName(articleName);
      imageService.deleteImageFilesystem(articleEntity.getImage().getFileName());
        articleService.deleteArticle(articleEntity);

        return "redirect:/home";
    }


    @ExceptionHandler(RuntimeException.class)

    public String handleRuntimeException(RuntimeException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
}
