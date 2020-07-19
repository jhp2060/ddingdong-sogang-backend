package com.ddingdongsogang.backend.springboot.web;

import com.ddingdongsogang.backend.springboot.service.notice.NoticeService;
import com.ddingdongsogang.backend.springboot.web.dto.NoticeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoticeApiController {
    private final NoticeService noticeService;

    @GetMapping("/api/v1/notices")
    public List<NoticeResponseDto> findAll() {
        return noticeService.findAll();
    }

    @GetMapping("/api/v1/board/notices")
    public List<NoticeResponseDto> findByBoardId(
            @RequestParam Long boardId) {
        return noticeService.findByBoardId(boardId);
    }

    @GetMapping("/api/v1/notices/{id}")
    public NoticeResponseDto findById(@PathVariable Long id) {
        return noticeService.findById(id);
    }
}
