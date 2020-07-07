package com.ddingdongsogang.backend.springboot.web;

import com.ddingdongsogang.backend.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// JSON 반환 controller
@RestController
public class HelloController {

    // HTTP GET method와 mapping
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    // @RequestParam : 외부에서 API에 전달한 파라미터를 가져오는 annotation
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
