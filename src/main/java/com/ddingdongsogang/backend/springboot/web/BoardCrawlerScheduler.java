package com.ddingdongsogang.backend.springboot.web;

import com.ddingdongsogang.backend.springboot.domain.board.BoardRepository;
import com.ddingdongsogang.backend.springboot.domain.notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/*
@Slf4j
@Component
@RequiredArgsConstructor
public class BoardCrawlerScheduler {
    private final BoardRepository boardRepository;
    private final NoticeRepository noticeRepository;
    private final BoardCrawler boardCrawler = new BoardCrawler(
            boardRepository, noticeRepository
    );

    // execute every hour
    @Scheduled(cron = "0 0 * * * *")
    public void run() throws IOException {
        log.info("crawling starts.");
        boardCrawler.saveNoticesOfAllBoard();
        log.info("crawling ended.");
    }

}
*/