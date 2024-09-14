package com.elaborato.simpleOnlineStore.persistence.storageManager;

import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class ImageStorageManagerImpl implements ImageStorageManager{
    private final String imagePath = "/home/terra/Documents/Spring/articleImages"; // Definisci il percorso di salvataggio delle immagini

    @Override
    public void saveInFilesystem(String fileName,  byte[] file){
        try {
            File destinationFile = new File(imagePath,fileName);
            if (!destinationFile.exists()) {
                destinationFile.getParentFile().mkdirs();
                destinationFile.createNewFile();
            }

            try (FileOutputStream fos = new FileOutputStream(destinationFile)) {
                fos.write(file);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image to filesystem", e);
        }
    }
@Override
public void deleteFromFilesystem(String fileName){
        File fileToDelete = new File(imagePath, fileName);

        if (fileToDelete.exists()) {
            if (!fileToDelete.delete()) {
                throw new RuntimeException("Failed to delete the image: " + fileName);
            }
        } else {
            throw new RuntimeException("Image file does not exist: " + fileName);
        }
    }
}
