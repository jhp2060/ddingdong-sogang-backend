package com.ddingdongsogang.backend.springboot.domain.site;

import com.ddingdongsogang.backend.springboot.domain.site.Site;
import com.ddingdongsogang.backend.springboot.domain.site.SiteRepository;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SiteRepositoryTest {

    @Autowired
    private SiteRepository siteRepository;

    @After
    public void tearDown() throws Exception {
        siteRepository.deleteAll();
    }

    @Test
    public void saveAndLoadSuccess() throws Exception {
        Faker faker = new Faker(new Locale("ko-KO"));
        String name = faker.lorem().sentence(10, 1);
        String url = faker.internet().url();

        siteRepository.save(Site.builder()
                .name(name)
                .url(url)
                .build()
        );

        List<Site> siteList = siteRepository.findAll();

        Site site = siteList.get(0);
        assertThat(site.getName()).isEqualTo(name);
        assertThat(site.getUrl()).isEqualTo(url);
    }
}
