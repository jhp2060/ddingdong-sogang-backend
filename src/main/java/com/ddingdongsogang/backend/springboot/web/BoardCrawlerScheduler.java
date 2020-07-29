package com.ddingdongsogang.backend.springboot.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class BoardCrawlerScheduler {
    private final BoardCrawler boardCrawler;

    // execute every hour
    @Scheduled(cron = "0 0 * * * *")
    public void run() throws IOException {
        log.info("crawling starts.");
        boardCrawler.saveNoticesOfAllBoard();
        log.info("crawling ended.");
    }

}
