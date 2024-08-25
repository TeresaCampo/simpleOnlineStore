package com.elaborato.simpleOnlineStore.domain.mappers;
import com.elaborato.simpleOnlineStore.domain.dto.ImageDto;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {
    private ModelMapper modelMapper;

    public ImageMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImageDto mapToDto(ImageEntity imageEntity){
        return modelMapper.map(imageEntity, ImageDto.class);
    }
    public ImageEntity mapToEntity(ImageDto imageDto){
        return modelMapper.map(imageDto, ImageEntity.class);
    }
}
