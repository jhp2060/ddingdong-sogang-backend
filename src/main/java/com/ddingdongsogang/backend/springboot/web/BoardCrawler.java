package com.ddingdongsogang.backend.springboot.web;

import com.ddingdongsogang.backend.springboot.domain.board.Board;
import com.ddingdongsogang.backend.springboot.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@RequiredArgsConstructor
public class BoardCrawler {
//    private final BoardRepository boardRepository;

    public String getNoticeTitle(Long id) throws IOException {
        /*
        Board board = boardRepository.findById(id).orElse(null);
        if (board == null) {
            System.out.println("You've got the wrong id for the board.");
            return null;
        }
        String url = board.getUrl();
        System.out.println("This is the board of " + board.getName());
        */
        String url = "http://www.sogang.ac.kr/front/boardlist.do?bbsConfigFK=1";
        Document doc = Jsoup.connect(url).get();
        Elements boardElements = doc.select("div.subject");
        for (Element e : boardElements) {
            String noticeUrl = "http://www.sogang.ac.kr" + e.getElementsByTag("a").first().attr("href");
            doc = Jsoup.connect(noticeUrl).get();
            Elements noticeElements = doc.select("span.text");
            String title = noticeElements.first().text();
            noticeElements = doc.select("div.unit");
            String author = noticeElements.get(0).select("span.value").text();
            System.out.println(noticeElements.get(0).select("span.value").text());
            LocalDateTime postedAt = LocalDateTime.parse(
                    noticeElements.get(1).select("span.value").text(),
                    DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
            System.out.println(title + " " + author + " "+ postedAt);

        }
        return doc.toString();
    }
}
