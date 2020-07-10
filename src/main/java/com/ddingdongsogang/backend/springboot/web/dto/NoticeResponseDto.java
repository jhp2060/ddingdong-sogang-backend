package com.ddingdongsogang.backend.springboot.web.dto;

import com.ddingdongsogang.backend.springboot.domain.notice.Notice;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoticeResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private String url;
    private LocalDateTime postedAt;
    private String boardName;

    public NoticeResponseDto(Notice entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.url = entity.getUrl();
        this.postedAt = entity.getPostedAt();
        this.boardName = entity.getBoard().getName();
    }

}
