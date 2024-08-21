package com.elaborato.simpleOnlineStore.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name="articles")
public class ArticleEntity {
    @Id
    private String name;
    private Double price;
    @Enumerated(EnumType.STRING)
    private Category category;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "image_id")
    private ImageEntity image;
}

