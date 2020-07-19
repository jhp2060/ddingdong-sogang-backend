package com.ddingdongsogang.backend.springboot.web.dto;

import com.ddingdongsogang.backend.springboot.domain.notice.Notice;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoticeRequestDto {

    private Long id;
    private Long actualId;
    private String title;
    private String author;
    private String url;
    private LocalDateTime postedAt;
    private String boardName;

    public NoticeRequestDto(Notice entity) {
        this.id = entity.getId();
        this.actualId = entity.getActualId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.url = entity.getUrl();
        this.postedAt = entity.getPostedAt();
        this.boardName = entity.getBoard().getName();
    }

}