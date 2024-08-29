package com.elaborato.simpleOnlineStore.domain.mappers;

import com.elaborato.simpleOnlineStore.domain.dto.ShopArticleCard;
import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import org.springframework.stereotype.Component;

@Component
public class ShopArticleCardMapper {
    public ArticleEntity toArticleEntity(ShopArticleCard shopArticleCard){
        return ArticleEntity.builder()
                .name(shopArticleCard.getName())
                .price(shopArticleCard.getPrice())
                .category(shopArticleCard.getCategory())
                .image(toImageEntity(shopArticleCard))
                .build();
    }

    public ImageEntity toImageEntity(ShopArticleCard shopArticleCard){
       return ImageEntity.builder()
               .fileName(shopArticleCard.getImageFileName())
               .build();
    }

    public ShopArticleCard toShopArticleCard(ArticleEntity articleEntity){
        return ShopArticleCard.builder()
                .name(articleEntity.getName())
                .price(articleEntity.getPrice())
                .category(articleEntity.getCategory())
                .imageFileName(articleEntity.getImage().getFileName())
                .build();
    }

}
