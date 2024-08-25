package com.elaborato.simpleOnlineStore.controllers;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

    @RestController
    public class ImageController {

        private final String imagePath = "/home/terra/Documents/Spring/articleImages";

        @GetMapping("/images")
        public ResponseEntity<Resource> getImage(@RequestParam String fileName) {
            try {
                File file = new File(imagePath + "/" + fileName);
                if (file.exists()) {
                    FileSystemResource resource = new FileSystemResource(file);
                    return ResponseEntity.ok()
                            .header(HttpHeaders.CONTENT_TYPE, "image/jpeg") // Adjust MIME type as needed
                            .body(resource);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    }

