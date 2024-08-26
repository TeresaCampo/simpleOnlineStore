/*package com.elaborato.simpleOnlineStore.domain;
import com.elaborato.simpleOnlineStore.domain.dto.ArticleDto;
import com.elaborato.simpleOnlineStore.domain.dto.ImageDto;
import com.elaborato.simpleOnlineStore.domain.entities.Category;
import com.elaborato.simpleOnlineStore.services.ArticleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private ArticleService articleService;

    public DataInitializer(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public void run(String... args) throws Exception {
        ImageDto image1= ImageDto.builder()
                .fileName("18688foto.jpg")
                .filePath("/home/terra/Documents/Spring/articleImages/18688foto.jpg\"")
                .build();
        ImageDto image2= ImageDto.builder()
                .fileName("images.jpeg")
                .filePath("/home/terra/Documents/Spring/articleImages/images.jpeg")
                .build();
        ImageDto image3= ImageDto.builder()
                .fileName("T7YLE_media_model_1.jpg")
                .filePath("/home/terra/Documents/Spring/articleImages/T7YLE_media_model_1.jpg\"")
                .build();
        ImageDto image4= ImageDto.builder()
                .fileName("tavola-da-surf-softboard-quicksilver-9-.jpg")
                .filePath("/home/terra/Documents/Spring/articleImages/tavola-da-surf-softboard-quicksilver-9-.jpg")
                .build();
        ImageDto image5= ImageDto.builder()
                .fileName("Tavola-surf-Sin-Noun-ocean-version.jpg")
                .filePath("/home/terra/Documents/Spring/articleImages/Tavola-surf-Sin-Noun-ocean-version.jpg")
                .build();

        ArticleDto article1= ArticleDto.builder()
                .name("number one")
                .category(Category.BEGINNERS)
                .price(400.0)
                .image(image1)
                .build();
        ArticleDto article2= ArticleDto.builder()
                .name("number two")
                .category(Category.BEGINNERS)
                .price(390.0)
                .image(image2)
                .build();
        ArticleDto article3= ArticleDto.builder()
                .name("number three")
                .category(Category.PROS)
                .price(600.0)
                .image(image3)
                .build();
        ArticleDto article4= ArticleDto.builder()
                .name("number four")
                .category(Category.PROS)
                .price(550.0)
                .image(image4)
                .build();
        ArticleDto article5= ArticleDto.builder()
                .name("number five")
                .category(Category.BEGINNERS)
                .price(400.0)
                .image(image5)
                .build();

        articleService.createArticle(article1);
        articleService.createArticle(article2);
        articleService.createArticle(article3);
        articleService.createArticle(article4);
        articleService.createArticle(article5);
    }
}*/
