package com.uplus.qualityweb.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class HelloControllerTest {


    @Test
    public void test1() {
        log.info("test ={}", true);
    }

}