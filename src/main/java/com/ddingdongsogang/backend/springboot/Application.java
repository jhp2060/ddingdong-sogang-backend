package com.ddingdongsogang.backend.springboot;

import com.ddingdongsogang.backend.springboot.web.BoardCrawler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJpaAuditing
//@EnableScheduling
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Exception{
        // spring boot 내장 WAS를 실행. Tomcat이 없어도 서비스 배포 및 실행 가능
        SpringApplication.run(Application.class, args);
//        BoardCrawler boardCrawler = new BoardCrawler(null);
//        boardCrawler.testAtLocal();
    }
}
