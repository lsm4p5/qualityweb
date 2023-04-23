package com.uplus.qualityweb.domain.posts;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;


import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {

        //given
        String title = "테스트 게시글";
        String content = "테스트 전문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("lsm4p5@gmail.com")
                .build());

        //when
        List<Posts> postsLis = postsRepository.findAll();

        //then
        Posts posts = postsLis.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BasicTimeEntity_등록() {

        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content(("content"))
                .author("author")
                .build()
        );

        //when
        List<Posts> all = postsRepository.findAll();

        //then
        Posts posts = all.get(0);
        log.info(">>>>>>>>>>> createdDate={}, modifiedDate={}", posts.getCreatedDate(), posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}