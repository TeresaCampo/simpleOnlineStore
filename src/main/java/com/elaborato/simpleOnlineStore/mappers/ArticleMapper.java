package com.elaborato.simpleOnlineStore.mappers;

import com.elaborato.simpleOnlineStore.domain.dto.ArticleDto;
import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {
    private final ModelMapper modelMapper;

    public ArticleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ArticleDto mapToDto(ArticleEntity articleEntity){
        return modelMapper.map(articleEntity, ArticleDto.class);
    }
    public ArticleEntity mapToEntity(ArticleDto articleDto){
        return modelMapper.map(articleDto, ArticleEntity.class);
    }
}
