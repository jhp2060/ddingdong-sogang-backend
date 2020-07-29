package com.ddingdongsogang.backend.springboot.domain.board;

import com.ddingdongsogang.backend.springboot.domain.site.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    public List<Board> findByNameContains(String name);
    public List<Board> findBySite(Site site);
}
