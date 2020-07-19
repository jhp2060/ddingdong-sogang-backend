package com.ddingdongsogang.backend.springboot.domain.board;

import com.ddingdongsogang.backend.springboot.domain.site.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    public List<Board> findByNameContains(String name);
    public List<Board> findBySite(Site site);
}
