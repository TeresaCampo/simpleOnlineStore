package com.elaborato.simpleOnlineStore.mappers;
import com.elaborato.simpleOnlineStore.domain.mappers.ArticleMapper;
import org.junit.jupiter.api.Test;
import com.elaborato.simpleOnlineStore.domain.dto.ArticleDto;
import com.elaborato.simpleOnlineStore.domain.dto.ImageDto;
import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import com.elaborato.simpleOnlineStore.domain.entities.ImageEntity;
import com.elaborato.simpleOnlineStore.util.TestDataUtil;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ArticleMapperTest {
    ArticleMapper articleMapper=new ArticleMapper(new ModelMapper());

    @Test
    public void conversionFromEntityToDto(){
        ArticleEntity articleEntity=TestDataUtil.createArticleEntity();
        ArticleDto articleDto= articleMapper.mapToDto(articleEntity);

        assertThat(articleDto.getName()).isEqualTo(articleEntity.getName());
        assertThat(articleDto.getPrice()).isEqualTo(articleEntity.getPrice());
        assertThat(articleDto.getCategory()).isEqualTo(articleEntity.getCategory());

        ImageDto imageDto=articleDto.getImage();
        ImageEntity imageEntity=articleEntity.getImage();
        assertThat(imageDto.getId()).isEqualTo(imageEntity.getId());
        assertThat(imageDto.getFileName()).isEqualTo(imageEntity.getFileName());
        assertThat(imageDto.getFilePath()).isEqualTo(imageEntity.getFilePath());
    }

    @Test
    public void conversionFromDtoToEntity(){
        ArticleDto articleDto= articleMapper.mapToDto(TestDataUtil.createArticleEntity());
        ArticleEntity articleEntity=articleMapper.mapToEntity(articleDto);

        assertThat(articleDto.getName()).isEqualTo(articleEntity.getName());
        assertThat(articleDto.getPrice()).isEqualTo(articleEntity.getPrice());
        assertThat(articleDto.getCategory()).isEqualTo(articleEntity.getCategory());

        ImageDto imageDto=articleDto.getImage();
        ImageEntity imageEntity=articleEntity.getImage();
        assertThat(imageDto.getId()).isEqualTo(imageEntity.getId());
        assertThat(imageDto.getFileName()).isEqualTo(imageEntity.getFileName());
        assertThat(imageDto.getFilePath()).isEqualTo(imageEntity.getFilePath());
    }
}
