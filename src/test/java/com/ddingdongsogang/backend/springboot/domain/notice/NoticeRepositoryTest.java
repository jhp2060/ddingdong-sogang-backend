package com.ddingdongsogang.backend.springboot.domain.notice;

import com.ddingdongsogang.backend.springboot.domain.board.Board;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeRepositoryTest {

    @Autowired
    NoticeRepository noticeRepository;

    @After
    public void cleanup() {
        noticeRepository.deleteAll();
    }

    @Test
    public void readNoticeSuccess() {
        String title = "공지사항";
        String author = "종합봉사실";
        String url = "http://sogang.ac.kr";
        LocalDateTime postedAt = LocalDateTime.now();
        Board board = new Board();
    }

}
