package com.ddingdongsogang.backend.springboot.domain.notice;

import com.ddingdongsogang.backend.springboot.domain.board.Board;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    public List<Notice> findByBoard(Board board);
    public boolean existsNoticeByActualIdAndBoard (Long actualId, Board board);
}
