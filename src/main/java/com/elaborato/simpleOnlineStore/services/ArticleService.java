package com.elaborato.simpleOnlineStore.services;

import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import java.util.List;

public interface ArticleService {
    ArticleEntity createArticleSQL(ArticleEntity articleEntity);

    boolean articleNameIsInvalidString(String articleName);

    boolean articleNameInUse(String articleName);

    ArticleEntity findArticleByName(String articleName);

    List<ArticleEntity> findAll();

    void deleteArticle(ArticleEntity articleEntity);
}
