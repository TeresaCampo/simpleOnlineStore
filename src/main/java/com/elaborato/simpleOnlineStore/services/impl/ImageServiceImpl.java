package com.elaborato.simpleOnlineStore.services.impl;

import com.elaborato.simpleOnlineStore.domain.dto.ShopFormDto;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import com.elaborato.simpleOnlineStore.repositories.ImageRepository;
import com.elaborato.simpleOnlineStore.services.ImageService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    ImageRepository imageRepository;
    private final String imagePath = "/home/terra/Documents/Spring/articleImages"; // Definisci il percorso di salvataggio delle immagini

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public ImageEntity createImageSQL(ImageEntity imageEntity) {
        return imageRepository.save(imageEntity);
    }

    @Override
    public ImageEntity createImageFilesystem(ShopFormDto shopFormDto)  {
        try {
            String imageName=shopFormDto.getName()+"__" +shopFormDto.getImage().getOriginalFilename();
            File destinationFile = new File(imagePath,imageName);
            if (!destinationFile.exists()) {
                destinationFile.getParentFile().mkdirs();
                destinationFile.createNewFile();
            }

            try (FileOutputStream fos = new FileOutputStream(destinationFile)) {
                fos.write(shopFormDto.getImage().getBytes());
            }
            return ImageEntity.builder()
                    .fileName(imageName)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image to filesystem", e);
        }
    }

    @Override
    public void deleteImageFilesystem(String imageName) {
        File fileToDelete = new File(imagePath, imageName);

        // Verifica se il file esiste
        if (fileToDelete.exists()) {
            // Prova a eliminare il file
            if (!fileToDelete.delete()) {
                throw new RuntimeException("Failed to delete the image: " + imageName);
            }
        } else {
            throw new RuntimeException("Image file does not exist: " + imageName);
        }
    }

}
