package com.elaborato.simpleOnlineStore.mappers;
import static org.assertj.core.api.Assertions.assertThat;
import com.elaborato.simpleOnlineStore.domain.dto.ImageDto;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import com.elaborato.simpleOnlineStore.util.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ImageMapperTests {
    ImageMapper imageMapper=new ImageMapper(new ModelMapper());

    @Test
    public void conversionFromEntityToDto(){
        ImageEntity imageEntity= TestDataUtil.createImageEntity();
        ImageDto imageDto= imageMapper.mapToDto(imageEntity);

        assertThat(imageDto.getId()).isEqualTo(imageEntity.getId());
        assertThat(imageDto.getFileName()).isEqualTo(imageEntity.getFileName());
        assertThat(imageDto.getFilePath()).isEqualTo(imageEntity.getFilePath());
    }

    public void conversionFromDtoToEntity(){
        ImageDto imageDto= imageMapper.mapToDto(TestDataUtil.createImageEntity());
        ImageEntity imageEntity = imageMapper.mapToEntity(imageDto);

        assertThat(imageDto.getId()).isEqualTo(imageEntity.getId());
        assertThat(imageDto.getFileName()).isEqualTo(imageEntity.getFileName());
        assertThat(imageDto.getFilePath()).isEqualTo(imageEntity.getFilePath());
    }
}
