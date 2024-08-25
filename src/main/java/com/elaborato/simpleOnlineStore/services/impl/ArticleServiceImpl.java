package com.elaborato.simpleOnlineStore.services.impl;
import com.elaborato.simpleOnlineStore.domain.dto.ArticleDto;
import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import com.elaborato.simpleOnlineStore.domain.mappers.ArticleMapper;
import com.elaborato.simpleOnlineStore.repositories.ArticleRepository;
import com.elaborato.simpleOnlineStore.services.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;
    private ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    @Override
    public ArticleEntity createArticle(ArticleDto articleDto) {
        return articleRepository.save(articleMapper.mapToEntity(articleDto));
    }

    @Override
    public List<ArticleDto> findAll() {
        return StreamSupport.stream(articleRepository.findAll().spliterator(), false)
                .map(articleEntity -> articleMapper.mapToDto(articleEntity))
                .collect(Collectors.toList());
    }
}
