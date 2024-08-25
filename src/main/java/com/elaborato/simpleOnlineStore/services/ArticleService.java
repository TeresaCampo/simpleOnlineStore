package com.elaborato.simpleOnlineStore.services;

import com.elaborato.simpleOnlineStore.domain.dto.ArticleDto;
import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;

public interface ArticleService {
    public ArticleEntity createArticle(ArticleDto articleDto);

}
