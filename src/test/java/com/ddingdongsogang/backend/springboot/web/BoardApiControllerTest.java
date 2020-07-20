package com.ddingdongsogang.backend.springboot.web;

import com.ddingdongsogang.backend.springboot.domain.board.Board;
import com.ddingdongsogang.backend.springboot.domain.board.BoardRepository;
import com.ddingdongsogang.backend.springboot.domain.site.Site;
import com.ddingdongsogang.backend.springboot.domain.site.SiteRepository;
import com.ddingdongsogang.backend.springboot.web.dto.BoardResponseDto;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private SiteRepository siteRepository;

    @After
    public void tearDown() throws Exception {
        boardRepository.deleteAll();
    }

    @Test
    public void findAllSuccess() throws Exception {
        Faker faker = new Faker(new Locale("ko-KO"));
        String siteName = faker.lorem().sentence(2);
        String boardName = faker.lorem().sentence(2);
        String url = faker.internet().url();

        siteRepository.save(Site.builder()
                .name(siteName)
                .url(url)
                .build()
        );

        boardRepository.save(Board.builder()
                .name(boardName)
                .actualId(faker.number().randomDigitNotZero())
                .url(url)
                .site(siteRepository.getOne(1L))
                .build()
        );

        String responseUrl = "http://localhost:"+port+"/api/v1/boards";

        ResponseEntity<List> responseEntity
                = restTemplate.getForEntity(responseUrl, List.class);

        LinkedHashMap<String, String> now =
                (LinkedHashMap<String, String>) responseEntity.getBody().get(0);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(now.get("name")).isEqualTo(boardName);
        assertThat(now.get("url")).isEqualTo(url);
//        assertThat(now.get("siteName")).isEqualTo(siteName);
    }

    @Test
    public void findByIdSuccess() throws Exception {
        Faker faker = new Faker(new Locale("ko-KO"));

        Site site1 = siteRepository.save(Site.builder()
                .name(faker.lorem().sentence(2))
                .url(faker.internet().url())
                .build()
        );

        Site site2 = siteRepository.save(Site.builder()
                .name(faker.lorem().sentence(2))
                .url(faker.internet().url())
                .build()
        );

        Board board1 = boardRepository.save(Board.builder()
                .name(faker.lorem().sentence(2))
                .url(faker.internet().url())
                .site(site1)
                .build()
        );

        Board board2 = boardRepository.save(Board.builder()
                .name(faker.lorem().sentence(2))
                .url(faker.internet().url())
                .site(site2)
                .build()
        );

        String responseUrl = "http://localhost:"+port+"/api/v1/boards/" +
                board1.getId();

        ResponseEntity<BoardResponseDto> responseEntity
                = restTemplate.getForEntity(responseUrl, BoardResponseDto.class);
        BoardResponseDto now = responseEntity.getBody();

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(now.getId()).isEqualTo(board1.getId());
        assertThat(now.getName()).isEqualTo(board1.getName());
        assertThat(now.getUrl()).isEqualTo(board1.getUrl());
        assertThat(now.getSiteName()).isEqualTo(site1.getName());
    }
}
