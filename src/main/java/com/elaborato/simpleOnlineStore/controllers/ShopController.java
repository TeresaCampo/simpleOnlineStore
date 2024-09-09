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
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ShopController {
    private final ArticleService articleService;
    private final ImageService imageService;
    private final SecurityService securityService;
    private final ShopFormMapper shopFormMapper;
    private final ShopArticleCardMapper shopArticleCardMapper;

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
                .map(shopArticleCardMapper::toShopArticleCard)
                .collect(Collectors.toList());
        model.addAttribute("articlesCards", articles);
        return "shop";
    }

    @PostMapping("/shop/upload")
    public String uploadArticle(@ModelAttribute("shopFormDto") ShopFormDto shopFormDto,
                                Model model){
        // Check for validation errors
            // input field: name
            boolean articleAlreadyExists=articleService.articleNameInUse(shopFormDto.getName());
            model.addAttribute("articleAlreadyExists", articleAlreadyExists);

            boolean nameIsInvalidString=articleService.articleNameIsInvalidString(shopFormDto.getName());
            model.addAttribute("nameIsInvalidString", nameIsInvalidString);
            if( articleAlreadyExists ||nameIsInvalidString ){
                shopFormDto.setName(null);
            }

            //input field: price
            boolean priceNotPositive=(shopFormDto.getPrice()<=0);
            model.addAttribute("priceNotPositive", priceNotPositive);
            if( priceNotPositive){
                shopFormDto.setPrice(null);
            }

        // If validation errors
        if (articleAlreadyExists || nameIsInvalidString ||  priceNotPositive ) {
            model.addAttribute("authenticatedUser", securityService.getAuthenticatedUserName());

            List<ShopArticleCardDto> articles = articleService.findAll().stream()
                    .map(shopArticleCardMapper::toShopArticleCard)
                    .collect(Collectors.toList());
            model.addAttribute("articlesCards", articles);
            return "shop";
        }

        //If no validation errors
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

        return "redirect:/shop";
    }
}
