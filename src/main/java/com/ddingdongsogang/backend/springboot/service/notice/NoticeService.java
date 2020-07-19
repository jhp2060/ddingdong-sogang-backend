package com.ddingdongsogang.backend.springboot.service.notice;

import com.ddingdongsogang.backend.springboot.domain.board.Board;
import com.ddingdongsogang.backend.springboot.domain.board.BoardRepository;
import com.ddingdongsogang.backend.springboot.domain.notice.Notice;
import com.ddingdongsogang.backend.springboot.domain.notice.NoticeRepository;
import com.ddingdongsogang.backend.springboot.web.dto.NoticeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;
    private final BoardRepository boardRepository;

    public List<NoticeResponseDto> findAll() {
        List<Notice> entities = noticeRepository.findAll();
        List<NoticeResponseDto> ret = new ArrayList<NoticeResponseDto>();
        for (Notice n : entities){
            ret.add(new NoticeResponseDto(n));
        }
        return ret;
    }

    public List<NoticeResponseDto> findByBoardId(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(
            () -> new IllegalArgumentException(
                "No board with that id (id: "+boardId+")")
        );

        List <Notice> entities = noticeRepository.findByBoard(board);
        List<NoticeResponseDto> ret = new ArrayList<NoticeResponseDto>();
        for (Notice n : entities){
            ret.add(new NoticeResponseDto(n));
        }
        return ret;
    }

    public NoticeResponseDto findById(Long id) {
        Notice entity = noticeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(
                        "No notices with that id (id: "+ id+")")
        );
        return new NoticeResponseDto(entity);
    }
}
