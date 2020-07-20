package com.ddingdongsogang.backend.springboot.web;

import com.ddingdongsogang.backend.springboot.domain.board.Board;
import com.ddingdongsogang.backend.springboot.domain.board.BoardRepository;
import com.ddingdongsogang.backend.springboot.domain.notice.Notice;
import com.ddingdongsogang.backend.springboot.domain.notice.NoticeRepository;
import com.ddingdongsogang.backend.springboot.domain.site.Site;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
public class BoardCrawler {
    private final BoardRepository boardRepository;
    private final NoticeRepository noticeRepository;

    public void testAtLocal() throws IOException {
        String url = "http://www.sogang.ac.kr/front/boardlist.do?bbsConfigFK=1";
        Document doc = Jsoup.connect(url).get();
        Elements boardElements = doc.select("div.subject");
        for (Element e : boardElements) {
            String noticeUrl = "http://www.sogang.ac.kr" + e.getElementsByTag("a").first().attr("href");
            doc = Jsoup.connect(noticeUrl).get();

            int actualNoticeId =Integer.parseInt(
                    noticeUrl.substring(
                            noticeUrl.indexOf("?pkid=") + 6, noticeUrl.indexOf("&")
                    ));
            System.out.print(actualNoticeId + ": ");
            Elements noticeElements = doc.select("span.text");

            String title = noticeElements.first().text();
            noticeElements = doc.select("div.unit");
            String author = noticeElements.get(0).select("span.value").text();
            LocalDateTime postedAt = LocalDateTime.parse(
                    noticeElements.get(1).select("span.value").text(),
                    DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));

            System.out.println(title + " / " + author + " / "+ postedAt);
        }
    }

    public void saveNoticesOfBoard(Long boardId) throws IOException {
        Board board = boardRepository.findById(boardId).orElse(null);
        if (board == null) {
            System.out.println("You've got the wrong id for the board.");
            return;
        }
        System.out.println("This is the board of " + board.getName());

        String siteName = board.getSite().getName();

        if (siteName.equals("세인트")) {
            saveNoticesOfSaintSite(board);
        }
        else if (siteName.equals("컴퓨터공학과")) {

        }
    }

    public void saveNoticesOfSaintSite(Board board) throws IOException {
        Site site = board.getSite();
        int page = 1;
        Long latestActualNoticeId = 0L;
        while (true) {
            String boardUrl = board.getUrl() + "&currentPage=" + page;
            Document doc = Jsoup.connect(boardUrl).get();
            Elements boardElements = doc.select("div.subject");
            for (Element e : boardElements) {
                String noticeUrl = board.getSite().getUrl() + e.getElementsByTag("a").first().attr("href");
                doc = Jsoup.connect(noticeUrl).get();

                Long actualNoticeId = Long.parseLong(
                        noticeUrl.substring(noticeUrl.indexOf("?pkid=") + 6, noticeUrl.indexOf("&"))
                );

                if (latestActualNoticeId < actualNoticeId) latestActualNoticeId = actualNoticeId;

                if (noticeRepository.existsNoticeByActualIdAndBoard(
                        actualNoticeId, board)) {
                    continue;
                }

                System.out.print(actualNoticeId + ": ");

                Elements noticeElements = doc.select("span.text");
                String title = noticeElements.first().text();
                noticeElements = doc.select("div.unit");
                String author = noticeElements.get(0).select("span.value").text();
                LocalDateTime postedAt = LocalDateTime.parse(
                        noticeElements.get(1).select("span.value").text(),
                        DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));

                System.out.println(title + " / " + author + " / "+ postedAt);

                Notice toSave = Notice.builder()
                        .actualId(actualNoticeId)
                        .title(title)
                        .author(author)
                        .postedAt(postedAt)
                        .url(noticeUrl)
                        .board(board)
                        .build();

                noticeRepository.save(toSave);
            }
            if (board.getLatestNoticeId() < latestActualNoticeId) ++page;
            else break;
        }
        board.setLatestNoticeId(latestActualNoticeId);
        boardRepository.save(board);
    }
}
