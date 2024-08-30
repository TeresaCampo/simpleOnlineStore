package com.elaborato.simpleOnlineStore.controllers;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
    public class ImageController {
        private final String imagePath = "/home/terra/Documents/Spring/articleImages";

        @GetMapping("/images")
        public ResponseEntity<Resource> getImage(@RequestParam String fileName) {
            try {
                Path file = Paths.get(imagePath, fileName);
                if (Files.exists(file)) {
                    FileSystemResource resource = new FileSystemResource(file);

                    String mimeType = Files.probeContentType(file);
                    if (mimeType == null) {
                        mimeType = "application/octet-stream"; // Fallback nif no valid MIME type is found
                    }

                    return ResponseEntity.ok()
                            .header(HttpHeaders.CONTENT_TYPE, mimeType)
                            .body(resource);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    }

