package com.elaborato.simpleOnlineStore.domain.dto;

import com.elaborato.simpleOnlineStore.domain.entities.Category;
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
