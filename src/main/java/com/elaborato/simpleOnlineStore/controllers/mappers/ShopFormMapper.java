package com.elaborato.simpleOnlineStore.controllers.mappers;

import com.elaborato.simpleOnlineStore.controllers.dto.ShopFormDto;
import com.elaborato.simpleOnlineStore.persistence.entities.ArticleEntity;
import com.elaborato.simpleOnlineStore.persistence.entities.ImageEntity;
import org.springframework.stereotype.Component;

@Component
public class ShopFormMapper {
    public ImageEntity toImageEntity(ShopFormDto shopFormDto){
        return ImageEntity.builder()
                .fileName(shopFormDto.getImage().getOriginalFilename())
                .build();
    }

    public ArticleEntity toArticleEntity(ShopFormDto shopFormDto){
        ImageEntity imageEntity=toImageEntity(shopFormDto);
        return ArticleEntity.builder()
                .name(shopFormDto.getName())
                .price(shopFormDto.getPrice())
                .category(shopFormDto.getCategory())
                .image(imageEntity)
                .build();
    }


}
