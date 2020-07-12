package com.ddingdongsogang.backend.springboot.service.site;

import com.ddingdongsogang.backend.springboot.domain.site.Site;
import com.ddingdongsogang.backend.springboot.domain.site.SiteRepository;
import com.ddingdongsogang.backend.springboot.web.dto.SiteResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SiteService {

    private final SiteRepository siteRepository;

    public List<SiteResponseDto> findAll() {
        List<Site> entities = siteRepository.findAll();
        List<SiteResponseDto> ret = new ArrayList<>();
        for (Site s : entities){
            ret.add(new SiteResponseDto(s));
        }
        return ret;
    }
}
