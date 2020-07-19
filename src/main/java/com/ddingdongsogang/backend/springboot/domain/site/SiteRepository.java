package com.ddingdongsogang.backend.springboot.domain.site;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Long> {
    public List<Site> findByNameContains(String Name);
}
