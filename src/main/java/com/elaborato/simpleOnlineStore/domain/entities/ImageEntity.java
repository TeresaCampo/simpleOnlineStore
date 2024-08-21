package com.elaborato.simpleOnlineStore.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "images")
public class ImageEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String fileName;
    private String filePath;
}
