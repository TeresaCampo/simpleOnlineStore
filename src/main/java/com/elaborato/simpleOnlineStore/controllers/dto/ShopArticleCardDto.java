package com.elaborato.simpleOnlineStore.controllers.dto;

import com.elaborato.simpleOnlineStore.persistence.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ShopArticleCardDto {
    private String name;
    private Double price;
    private Category category;
    private String imageFileName;
}
