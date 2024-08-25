package com.elaborato.simpleOnlineStore.services.impl;

import com.elaborato.simpleOnlineStore.domain.dto.ImageDto;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import com.elaborato.simpleOnlineStore.domain.mappers.ImageMapper;
import com.elaborato.simpleOnlineStore.repositories.ImageRepository;
import com.elaborato.simpleOnlineStore.services.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    ImageRepository imageRepository;
    ImageMapper imageMapper;

    public ImageServiceImpl(ImageRepository imageRepository, ImageMapper imageMapper) {
        this.imageRepository = imageRepository;
        this.imageMapper = imageMapper;
    }

    @Override
    public ImageEntity createImage(ImageDto imageDto) {
        //salvare immagine nella cartella articleIMages del filesystem
        return imageRepository.save(imageMapper.mapToEntity(imageDto));

    }
}
