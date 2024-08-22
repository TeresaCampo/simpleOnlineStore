package com.elaborato.simpleOnlineStore.repositories;
import static org.assertj.core.api.Assertions.assertThat;

import com.elaborato.simpleOnlineStore.util.TestDataUtil;
import com.elaborato.simpleOnlineStore.domain.entities.ArticleEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ArticleRepositoryIntegrationTests {

    private ArticleRepository articleRepositoryUT;
    private TestDataUtil testDataUtil;

    @Autowired
    public ArticleRepositoryIntegrationTests(ArticleRepository articleRepository, TestDataUtil testDataUtil) {
        this.articleRepositoryUT = articleRepository;
        this.testDataUtil = testDataUtil;
    }

    @Test
    public void testThatArticleCanBeCreatedAndRecalled(){
        ArticleEntity article= testDataUtil.createArticleEntity();
        articleRepositoryUT.save(article);
        article.getImage().setId(1L);
        Optional<ArticleEntity> result= articleRepositoryUT.findById(article.getName());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(article);

    }
}
