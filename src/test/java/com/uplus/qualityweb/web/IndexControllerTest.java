package com.uplus.qualityweb.web;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.nio.charset.Charset;
import java.util.Arrays;


@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {


        //when

//        HttpHeaders headers = new HttpHeaders();
//        headers.setAcceptCharset(Arrays.asList(Charset.forName("UTF-8")));
//        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//        System.out.println("entity = " + entity.toString());
//        ResponseEntity<String> response = restTemplate.exchange("/", HttpMethod.GET, entity, String.class);
//
//        String body = response.getBody();
//        System.out.println("response = " + response.toString());
        String body = restTemplate.getForObject("/", String.class);
        log.info("body={}", body);

        //then
       // Assertions.assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");

    }

}