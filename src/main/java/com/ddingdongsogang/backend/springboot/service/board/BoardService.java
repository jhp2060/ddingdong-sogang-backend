package com.ddingdongsogang.backend.springboot.service.board;

import com.ddingdongsogang.backend.springboot.domain.board.Board;
import com.ddingdongsogang.backend.springboot.domain.board.BoardRepository;
import com.ddingdongsogang.backend.springboot.domain.notice.Notice;
import com.ddingdongsogang.backend.springboot.domain.site.Site;
import com.ddingdongsogang.backend.springboot.domain.site.SiteRepository;
import com.ddingdongsogang.backend.springboot.web.dto.BoardResponseDto;
import com.ddingdongsogang.backend.springboot.web.dto.SiteResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final SiteRepository siteRepository;

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
    /*
    public List<BoardResponseDto> findBySiteId(String siteName) {
        Site site = siteRepository.findByNameContains(siteName).get(0);
        List<Board> boardList = boardRepository.findBySite(site);
        List<BoardResponseDto> ret
    }
    */
}
