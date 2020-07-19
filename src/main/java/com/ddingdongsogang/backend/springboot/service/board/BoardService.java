package com.ddingdongsogang.backend.springboot.service.board;

import com.ddingdongsogang.backend.springboot.domain.board.Board;
import com.ddingdongsogang.backend.springboot.domain.board.BoardRepository;
import com.ddingdongsogang.backend.springboot.domain.notice.Notice;
import com.ddingdongsogang.backend.springboot.domain.notice.NoticeRepository;
import com.ddingdongsogang.backend.springboot.domain.site.Site;
import com.ddingdongsogang.backend.springboot.domain.site.SiteRepository;
import com.ddingdongsogang.backend.springboot.web.BoardCrawler;
import com.ddingdongsogang.backend.springboot.web.dto.BoardResponseDto;
import com.ddingdongsogang.backend.springboot.web.dto.SiteResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final SiteRepository siteRepository;
    private final BoardRepository boardRepository;
    private final NoticeRepository noticeRepository;

    public List<BoardResponseDto> findAll() {
        List<Board> entities = boardRepository.findAll();
        List<BoardResponseDto> ret = new ArrayList<>();
        for (Board b : entities)
            ret.add(new BoardResponseDto(b));
        return ret;
    }

    public BoardResponseDto findById(Long id) {
        return new BoardResponseDto(
                boardRepository.findById(id).orElseThrow(
                        () -> new IllegalArgumentException(
                                "No boards with that id (id: "+ id +")"
                        )
                )
        );
    }

    public List<BoardResponseDto> findBySiteId(String siteName) {
        Site site = siteRepository.findByNameContains(siteName).get(0);
        List<Board> boardList = boardRepository.findBySite(site);
        List<BoardResponseDto> ret = new ArrayList<>();
        for (Board b : boardList)
            ret.add(new BoardResponseDto(b));
        return ret;
    }

    public BoardResponseDto crawlAndSaveNewNotices(Long id) {
        BoardCrawler boardCrawler = new BoardCrawler(boardRepository, noticeRepository);
        try {
            boardCrawler.saveNoticesOfBoard(id);
        } catch (IOException e) {
            System.out.print("\n\n\n\n\n\n"+e.getMessage()+"\n\n\n\n\n\n");
            return null;
        }
        return new BoardResponseDto(boardRepository.getOne(id));
    }
}
