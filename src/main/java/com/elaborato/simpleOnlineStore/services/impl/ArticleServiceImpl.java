package com.elaborato.simpleOnlineStore.services.impl;
import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import com.elaborato.simpleOnlineStore.repositories.ArticleRepository;
import com.elaborato.simpleOnlineStore.services.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public boolean articleNameIsInvalidString(String articleName){
        if(articleName.length()==0) return true;
        return !articleName.chars().anyMatch(c -> !Character.isWhitespace(c));
    }

    @Override
    public boolean articleNameInUse(String articleName){
        return articleRepository.findByName(articleName).isPresent();

    }

    @Override
    public ArticleEntity findArticleByName(String articleName){
        return articleRepository.findByName(articleName).orElse(null);

    }
    @Override
    public List<ArticleEntity> findAll() {
        return StreamSupport.stream(articleRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleEntity createArticleSQL(ArticleEntity articleEntity) {
        return articleRepository.save(articleEntity);
    }

    @Override
    public void deleteArticle(ArticleEntity articleEntity){
        articleRepository.delete(articleEntity);

    }
}
