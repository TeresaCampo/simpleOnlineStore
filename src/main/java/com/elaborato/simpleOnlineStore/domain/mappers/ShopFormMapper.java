package com.elaborato.simpleOnlineStore.domain.mappers;

import com.elaborato.simpleOnlineStore.domain.dto.ShopFormDto;
import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
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
