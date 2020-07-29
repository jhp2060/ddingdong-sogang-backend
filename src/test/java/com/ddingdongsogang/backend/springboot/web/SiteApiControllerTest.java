package com.ddingdongsogang.backend.springboot.web;

import com.ddingdongsogang.backend.springboot.domain.site.Site;
import com.ddingdongsogang.backend.springboot.domain.site.SiteRepository;
import com.ddingdongsogang.backend.springboot.web.dto.SiteResponseDto;
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

import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SiteApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SiteRepository siteRepository;


    @After
    public void tearDown() throws Exception {
        siteRepository.deleteAll();
    }

    @Test
    public void findAllSuccess() throws Exception{
        Faker faker = new Faker(new Locale("ko-KO"));
        String name = faker.lorem().sentence(3);
        String url = faker.internet().url();

        siteRepository.save(Site.builder()
                .name(name)
                .url(url)
                .build()
        );

        String responseUrl = "http://localhost:"+port+"/api/v1/sites";

        ResponseEntity<List> responseEntity
                = restTemplate.getForEntity(responseUrl, List.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
