package com.elaborato.simpleOnlineStore.repositories;

import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<ImageEntity,Long> {
}
