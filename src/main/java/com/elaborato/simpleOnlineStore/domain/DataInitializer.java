package com.elaborato.simpleOnlineStore.domain;
import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import com.elaborato.simpleOnlineStore.domain.entities.Category;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
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
        ImageEntity image1= ImageEntity.builder()
                .fileName("image1.jpg")
                .build();
        ImageEntity image2= ImageEntity.builder()
                .fileName("image2.jpg")
                .build();
        ImageEntity image3= ImageEntity.builder()
                .fileName("image3.jpeg")
                .build();
        ImageEntity image4= ImageEntity.builder()
                .fileName("image4.jpg")
                .build();
        ImageEntity image5= ImageEntity.builder()
                .fileName("image5.jpg")
                .build();

        ArticleEntity article1= ArticleEntity.builder()
                .name("number one")
                .category(Category.BEGINNERS)
                .price(400.0)
                .image(image1)
                .build();
        ArticleEntity article2= ArticleEntity.builder()
                .name("number two")
                .category(Category.BEGINNERS)
                .price(390.0)
                .image(image2)
                .build();
        ArticleEntity article3= ArticleEntity.builder()
                .name("number three")
                .category(Category.PROS)
                .price(600.0)
                .image(image3)
                .build();
        ArticleEntity article4= ArticleEntity.builder()
                .name("number four")
                .category(Category.PROS)
                .price(550.0)
                .image(image4)
                .build();
        ArticleEntity article5= ArticleEntity.builder()
                .name("number five")
                .category(Category.BEGINNERS)
                .price(400.0)
                .image(image5)
                .build();

        articleService.createArticleSQL(article1);
        articleService.createArticleSQL(article2);
        articleService.createArticleSQL(article3);
        articleService.createArticleSQL(article4);
        articleService.createArticleSQL(article5);
    }
}
