package com.ddingdongsogang.backend.springboot.domain.site;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=400, nullable = false)
    private String name;

    @Column(length=300, nullable = false)
    private String url;

    @Builder
    public Site(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
