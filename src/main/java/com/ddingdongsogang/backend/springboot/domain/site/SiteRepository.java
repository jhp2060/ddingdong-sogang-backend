package com.ddingdongsogang.backend.springboot.domain.site;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
    public List<Site> findByNameContains(String Name);
}
