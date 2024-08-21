package com.elaborato.simpleOnlineStore.repositories;

import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<ArticleEntity,String> {
}
