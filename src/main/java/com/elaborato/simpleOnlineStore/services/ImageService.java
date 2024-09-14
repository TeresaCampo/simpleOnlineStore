package com.elaborato.simpleOnlineStore.services;

import com.elaborato.simpleOnlineStore.controllers.dto.ShopFormDto;
import com.elaborato.simpleOnlineStore.persistence.entities.ImageEntity;

public interface ImageService {
    public ImageEntity createImageSQL(ImageEntity imageEntity);


    ImageEntity createImageFilesystem(ShopFormDto shopFormDto);


    void deleteImageFilesystem(String imageName);
}
