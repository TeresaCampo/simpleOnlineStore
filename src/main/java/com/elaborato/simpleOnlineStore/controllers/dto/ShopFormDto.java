package com.elaborato.simpleOnlineStore.controllers.dto;

import com.elaborato.simpleOnlineStore.persistence.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ShopFormDto {
    private String name;
    private Double price;
    private Category category;
    private MultipartFile image;
}


