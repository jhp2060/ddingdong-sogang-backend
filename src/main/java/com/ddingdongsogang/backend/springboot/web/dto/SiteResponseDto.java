package com.ddingdongsogang.backend.springboot.web.dto;

import com.ddingdongsogang.backend.springboot.domain.site.Site;
import lombok.Getter;

@Getter
public class SiteResponseDto {
    private Long id;
    private String name;
    private String url;

    public SiteResponseDto(Site entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.url = entity.getUrl();
    }

}
