package com.ddingdongsogang.backend.springboot.domain.board;

import com.ddingdongsogang.backend.springboot.domain.site.Site;
import com.ddingdongsogang.backend.springboot.domain.subscription.Subscription;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int actualId;

    @Column
    private Long latestNoticeId;

    @Column(length=100, nullable=false)
    private String name;

    @Column(length=300, nullable=false)
    private String url;

    @ManyToOne
    @JoinColumn(name="site_id")
    private Site site;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "board"
    )
    private Set<Subscription> subscriptions;

    @Builder
    public Board(int actualId, String name, String url, Site site) {
        this.actualId = actualId;
        this.latestNoticeId = 0L;
        this.name = name;
        this.url = url;
        this.site = site;
    }
}
