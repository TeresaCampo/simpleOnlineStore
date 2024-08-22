package com.elaborato.simpleOnlineStore.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ImageDto {
    Long id;
    private String fileName;
    private String filePath;
}
