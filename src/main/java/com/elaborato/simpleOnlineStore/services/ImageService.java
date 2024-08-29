package com.elaborato.simpleOnlineStore.services;

import com.elaborato.simpleOnlineStore.domain.dto.ShopFormDto;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    public ImageEntity createImageSQL(ImageEntity imageEntity);


    ImageEntity createImageFilesystem(ShopFormDto shopFormDto);


    void deleteImageFilesystem(String imageName);
}
