package com.uplus.qualityweb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
@Slf4j
public class QualitywebApplication {

	public static void main(String[] args) {

		SpringApplication.run(QualitywebApplication.class, args);
		log.info("프로그램 시작 ");

	}

}
