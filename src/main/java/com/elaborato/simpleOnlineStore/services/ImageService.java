package com.elaborato.simpleOnlineStore.services;

import com.elaborato.simpleOnlineStore.domain.dto.ImageDto;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;

public interface ImageService {
    public ImageEntity createImage(ImageDto imageDto);

}
