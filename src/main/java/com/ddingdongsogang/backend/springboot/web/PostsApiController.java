package com.ddingdongsogang.backend.springboot.web;

import com.ddingdongsogang.backend.springboot.web.dto.PostsResponseDto;
import com.ddingdongsogang.backend.springboot.web.dto.PostsSaveRequestDto;
import com.ddingdongsogang.backend.springboot.service.posts.PostsService;
import com.ddingdongsogang.backend.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        // return the Id of the saved post
        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        // return the Id of the updated post
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        // return the response body
        return postService.findById(id);
    }

}
