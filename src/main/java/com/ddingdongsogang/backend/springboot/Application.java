package com.ddingdongsogang.backend.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // spring boot 내장 WAS를 실행. Tomcat이 없어도 서비스 배포 및 실행 가능
        SpringApplication.run(Application.class, args);
    }
}
