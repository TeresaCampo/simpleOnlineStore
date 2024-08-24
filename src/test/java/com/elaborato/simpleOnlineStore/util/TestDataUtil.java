package com.elaborato.simpleOnlineStore.util;

import com.elaborato.simpleOnlineStore.domain.dto.ArticleDto;
import com.elaborato.simpleOnlineStore.domain.dto.ImageDto;
import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import com.elaborato.simpleOnlineStore.domain.entities.Category;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import org.springframework.stereotype.Component;

@Component
public final class TestDataUtil {
    public static ArticleEntity createArticleEntity(){

        ImageEntity image = createImageEntity();

        return ArticleEntity.builder()
                .name("aurora")
                .price(20.0)
                .category(Category.NECKLACE)
                .image(image)
                .build();
    }

    public static ImageEntity createImageEntity() {
        ImageEntity image = ImageEntity.builder()
                .fileName("Praia_Do_Norte.jpg")
                .filePath("/home/terra/Documents/Spring/uploadImages" + "Praia_Do_Norte.jpg")
                .build();
        return image;
    }

    public ArticleDto createArticleDto(){
        ImageDto image = createImageDto();
        return ArticleDto.builder()
                .name("aurora")
                .price(20.0)
                .category(Category.NECKLACE)
                .image(image)
                .build();
    }

    public static ImageDto createImageDto() {
        ImageDto image = ImageDto.builder()
                .fileName("Praia_Do_Norte.jpg")
                .filePath("/home/terra/Documents/Spring/uploadImages" + "Praia_Do_Norte.jpg")
                .build();
        return image;
    }


}
