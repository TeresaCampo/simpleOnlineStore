package com.elaborato.simpleOnlineStore.domain.dto;
import com.elaborato.simpleOnlineStore.domain.entities.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotEmpty
    private String name;
    @Positive
    private Double price;
    @NotNull
    private Category category;
    @NotNull
    MultipartFile image;
}


