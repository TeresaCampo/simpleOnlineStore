package com.elaborato.simpleOnlineStore;

import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import com.elaborato.simpleOnlineStore.domain.entities.Category;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import org.springframework.stereotype.Component;

@Component
public final class TestDataUtil {
    public ArticleEntity createArticleEntity(){

        ImageEntity image = ImageEntity.builder()
                .fileName("Praia_Do_Norte,_Nazaré,_Portugal.jpg")
                .filePath("/home/terra/Documents/Spring/uploadImages" + "Praia_Do_Norte,_Nazaré,_Portugal.jpg")
                .build();

        return ArticleEntity.builder()
                .name("aurora")
                .price(20.0)
                .category(Category.NECKLACE)
                .image(image)
                .build();
    }
}
