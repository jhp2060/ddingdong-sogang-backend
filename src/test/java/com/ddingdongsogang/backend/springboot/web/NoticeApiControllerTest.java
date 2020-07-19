package com.ddingdongsogang.backend.springboot.web;

import com.ddingdongsogang.backend.springboot.domain.board.Board;
import com.ddingdongsogang.backend.springboot.domain.board.BoardRepository;
import com.ddingdongsogang.backend.springboot.domain.notice.Notice;
import com.ddingdongsogang.backend.springboot.domain.notice.NoticeRepository;
import com.ddingdongsogang.backend.springboot.domain.site.Site;
import com.ddingdongsogang.backend.springboot.domain.site.SiteRepository;
import com.ddingdongsogang.backend.springboot.web.dto.NoticeResponseDto;
import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NoticeApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    SiteRepository siteRepository;

    @Autowired
    BoardRepository boardRepository;

    @After
    public void tearDown() throws Exception {
        noticeRepository.deleteAll();
    }

    @Test
    public void findAllSuccess() throws Exception{
        Faker faker = new Faker(new Locale("ko-KO"));
        String title = faker.lorem().sentence(3);
        String author = faker.lorem().word();
        String url = faker.internet().url();
        LocalDateTime postedAt = LocalDateTime.now();

        siteRepository.save(Site.builder()
                .name(title)
                .url(url)
                .build()
        );

        boardRepository.save(Board.builder()
                .name(title)
                .url(url)
                .site(siteRepository.getOne(1L))
                .build()
        );
        Board board = boardRepository.findById(1L).orElse(null);
        noticeRepository.save(Notice.builder()
                .title(title)
                .author(author)
                .url(url)
                .postedAt(postedAt)
                .board(board)
                .build()
        );

        String responseUrl = "http://localhost:"+port+"/api/v1/notices";

        ResponseEntity<List> responseEntity
                = restTemplate.getForEntity(responseUrl, List.class);

        LinkedHashMap<String, String> now =
                (LinkedHashMap<String, String>) responseEntity.getBody().get(0);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(now.get("title")).isEqualTo(title);
        assertThat(now.get("author")).isEqualTo(author);
        assertThat(LocalDateTime.parse(now.get("postedAt"))).isEqualTo(postedAt);
        assertThat(now.get("boardName")).isEqualTo(board.getName());
    }
}
