package com.ddingdongsogang.backend.springboot.web;


import com.ddingdongsogang.backend.springboot.service.site.SiteService;
import com.ddingdongsogang.backend.springboot.web.dto.SiteResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SiteApiController {
    private final SiteService siteService;

    @GetMapping("/api/v1/site")
    public List<SiteResponseDto> findAll() {
        return siteService.findAll();
    }
}
