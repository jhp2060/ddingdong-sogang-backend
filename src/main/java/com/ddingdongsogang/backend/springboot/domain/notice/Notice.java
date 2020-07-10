package com.ddingdongsogang.backend.springboot.domain.notice;

import com.ddingdongsogang.backend.springboot.domain.board.Board;
import com.ddingdongsogang.backend.springboot.domain.shared.BaseTimeEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
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

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

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
    public Notice(String title, String content, Board board) {
        this.title = title;
        this.content = content;
        this.board = board;
    }
}
