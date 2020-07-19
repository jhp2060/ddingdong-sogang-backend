package com.ddingdongsogang.backend.springboot.web;

import com.ddingdongsogang.backend.springboot.service.board.BoardService;
import com.ddingdongsogang.backend.springboot.web.dto.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;

    @GetMapping("/api/v1/boards")
    public List<BoardResponseDto> findAll() {
        return boardService.findAll();
    }

    @GetMapping("api/v1/boards/{id}")
    public BoardResponseDto findById(
            @PathVariable Long id) {
        return boardService.findById(id);
    }


}
