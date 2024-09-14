package com.elaborato.simpleOnlineStore.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "images")
public class ImageEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String fileName;
}
