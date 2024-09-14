package com.elaborato.simpleOnlineStore.persistence.storageManager;

public interface ImageStorageManager {
    void saveInFilesystem(String fileName,  byte[] file);
    void deleteFromFilesystem(String fileName);
}
