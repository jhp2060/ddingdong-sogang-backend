package com.ddingdongsogang.backend.springboot.web.dto;

import com.ddingdongsogang.backend.springboot.domain.board.Board;
import com.ddingdongsogang.backend.springboot.domain.notice.Notice;
import com.ddingdongsogang.backend.springboot.domain.notice.NoticeRepository;
import lombok.Getter;

import java.util.List;

@Getter
public class BoardResponseDto {
    private Long id;
    private String name;
    private String url;
    private String siteName;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.name = board.getName();
        this.url = board.getUrl();
        this.siteName = board.getSite().getName();
    }
}
