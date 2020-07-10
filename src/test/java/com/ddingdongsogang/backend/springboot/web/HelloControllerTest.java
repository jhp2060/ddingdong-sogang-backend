package com.ddingdongsogang.backend.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

// static import in Java : 특정 class의 static method만을 import. 해당 class의 인스턴스 불필요.
// static method를 단순 함수처럼 사용
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)    // 스프링 부트 테스트와 JUnit 연결
@WebMvcTest(controllers = HelloController.class)    // web mvc controller에만 집중
public class HelloControllerTest {

    @Autowired  // 스프링이 관리하는 bean을 주입
    private MockMvc mvc;    // api 테스트용 mvc
    /**
    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))           // /hello로 get 요청
                .andExpect(status().isOk())             // status=200 검증
                .andExpect(content().string(hello));    // controller의 반환 값 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
    **/
}
