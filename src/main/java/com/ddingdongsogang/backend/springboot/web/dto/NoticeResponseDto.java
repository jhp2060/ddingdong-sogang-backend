package com.ddingdongsogang.backend.springboot.web.dto;

import com.ddingdongsogang.backend.springboot.domain.notice.Notice;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoticeResponseDto {

    private String title;
    private String author;
    private String url;
    private LocalDateTime postedAt;
    private String siteName;
    private String boardName;

    public NoticeResponseDto(Notice entity) {
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.url = entity.getUrl();
        this.postedAt = entity.getPostedAt();
        this.siteName = entity.getBoard().getSite().getName();
        this.boardName = entity.getBoard().getName();
    }

}
