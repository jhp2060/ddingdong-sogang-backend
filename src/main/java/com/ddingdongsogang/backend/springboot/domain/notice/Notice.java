package com.ddingdongsogang.backend.springboot.domain.notice;

import com.ddingdongsogang.backend.springboot.domain.board.Board;
import com.ddingdongsogang.backend.springboot.domain.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Notice extends BaseTimeEntity {

    @Id     // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long actualId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length=20)
    private String author;

    @Column(length=300)
    private String url;

    @Column
    private LocalDateTime postedAt;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    public Notice(Long actualId, String title,
                  String author, String url, LocalDateTime postedAt,
                  Board board) {
        this.actualId = actualId;
        this.title = title;
        this.author = author;
        this.url = url;
        this.postedAt = postedAt;
        this.board = board;
    }
}
