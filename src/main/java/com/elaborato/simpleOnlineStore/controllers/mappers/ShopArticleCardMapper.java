package com.elaborato.simpleOnlineStore.controllers.mappers;

import com.elaborato.simpleOnlineStore.controllers.dto.ShopArticleCardDto;
import com.elaborato.simpleOnlineStore.persistence.entities.ArticleEntity;
import com.elaborato.simpleOnlineStore.persistence.entities.ImageEntity;
import org.springframework.stereotype.Component;

@Component
public class ShopArticleCardMapper {
    public ArticleEntity toArticleEntity(ShopArticleCardDto shopArticleCardDto){
        return ArticleEntity.builder()
                .name(shopArticleCardDto.getName())
                .price(shopArticleCardDto.getPrice())
                .category(shopArticleCardDto.getCategory())
                .image(toImageEntity(shopArticleCardDto))
                .build();
    }

    public ImageEntity toImageEntity(ShopArticleCardDto shopArticleCardDto){
       return ImageEntity.builder()
               .fileName(shopArticleCardDto.getImageFileName())
               .build();
    }

    public ShopArticleCardDto toShopArticleCard(ArticleEntity articleEntity){
        return ShopArticleCardDto.builder()
                .name(articleEntity.getName())
                .price(articleEntity.getPrice())
                .category(articleEntity.getCategory())
                .imageFileName(articleEntity.getImage().getFileName())
                .build();
    }

}
