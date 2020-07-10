package com.ddingdongsogang.backend.springboot.domain.board;

import com.ddingdongsogang.backend.springboot.domain.notice.Notice;
import com.ddingdongsogang.backend.springboot.domain.site.Site;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.URL;
import java.util.Collection;

@Getter
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=100, nullable=false)
    private String name;

    @Column(length=300, nullable=false)
    private String url;

    @ManyToOne
    @JoinColumn(name="site_id")
    private Site site;

    @Builder
    public Board(String name, String url, Site site) {
        this.name = name;
        this.url = url;
        this.site = site;
    }
}
