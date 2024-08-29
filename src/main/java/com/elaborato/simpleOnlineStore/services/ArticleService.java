package com.elaborato.simpleOnlineStore.services;

import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import java.util.List;

public interface ArticleService {
    ArticleEntity createArticleSQL(ArticleEntity articleEntity);

    boolean articleNameInUse(String articleName);

    List<ArticleEntity> findAll();

}
