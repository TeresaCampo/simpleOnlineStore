package com.elaborato.simpleOnlineStore.services;

import com.elaborato.simpleOnlineStore.domain.dto.ArticleDto;
import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;

import java.util.List;

public interface ArticleService {
    public ArticleEntity createArticle(ArticleDto articleDto);

    public List<ArticleDto> findAll();

}
