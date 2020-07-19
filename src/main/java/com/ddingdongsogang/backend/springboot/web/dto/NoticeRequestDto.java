package com.ddingdongsogang.backend.springboot.web.dto;

import com.ddingdongsogang.backend.springboot.domain.board.Board;
import com.ddingdongsogang.backend.springboot.domain.notice.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class NoticeRequestDto {

    private Long id;
    private Long actualId;
    private String title;
    private String author;
    private String url;
    private LocalDateTime postedAt;
    private Board board;

    @Builder
    public NoticeRequestDto(Notice entity) {
        this.id = entity.getId();
        this.actualId = entity.getActualId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.url = entity.getUrl();
        this.postedAt = entity.getPostedAt();
        this.board = entity.getBoard();
    }

    public Notice toEntity() {
        return Notice.builder()
                .actualId(actualId)
                .title(title)
                .author(author)
                .url(url)
                .postedAt(postedAt)
                .board(board)
                .build();
    }
}