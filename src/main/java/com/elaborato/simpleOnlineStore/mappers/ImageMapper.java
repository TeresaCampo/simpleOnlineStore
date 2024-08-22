package com.elaborato.simpleOnlineStore.mappers;
import com.elaborato.simpleOnlineStore.domain.dto.ImageDto;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import org.modelmapper.ModelMapper;

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
