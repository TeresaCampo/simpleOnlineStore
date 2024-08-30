package com.elaborato.simpleOnlineStore.domain;

import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import com.elaborato.simpleOnlineStore.domain.entities.Category;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import com.elaborato.simpleOnlineStore.services.ArticleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class DataInitializer implements CommandLineRunner {
    private final ArticleService articleService;
    public DataInitializer(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public void run(String... args) {
        addArticleIfNotExists("number one", Category.BEGINNERS, 300.5,"image1.jpg");
        addArticleIfNotExists("number two", Category.PROS, 420.0,"image2.jpg");
        addArticleIfNotExists("number three", Category.BEGINNERS, 290.5,"image3.jpeg");
        addArticleIfNotExists("number four", Category.PROS, 370.4,"image4.jpg");
        addArticleIfNotExists("number five", Category.BEGINNERS, 300.5,"image5.jpg");
    }

    private void addArticleIfNotExists(String name, Category category, Double price, String imageFileName) {
        if (articleService.articleNameInUse(name)) return;
        else {
            ImageEntity image = ImageEntity.builder()
                    .fileName(imageFileName)
                    .build();

            ArticleEntity article = ArticleEntity.builder()
                    .name(name)
                    .category(category)
                    .price(price)
                    .image(image)
                    .build();
            articleService.createArticleSQL(article);
        }
    }
}

