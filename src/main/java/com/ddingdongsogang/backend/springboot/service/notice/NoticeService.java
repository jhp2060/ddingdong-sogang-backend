package com.ddingdongsogang.backend.springboot.service.notice;

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

    public List<NoticeResponseDto> findAll() {
        List<Notice> entities = noticeRepository.findAll();
        List<NoticeResponseDto> ret = new ArrayList<NoticeResponseDto>();
        for (Notice n : entities){
            ret.add(new NoticeResponseDto(n));
        }
        return ret;
    }

    public List<NoticeResponseDto> findByBoardId(Long boardId) {
        /*
        Board board = boardRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException(
                "No board with that id (id: "+boardId"+")")
        );
        */
        List <Notice> entities = noticeRepository.findAll();
        List<NoticeResponseDto> ret = new ArrayList<NoticeResponseDto>();
        entities.stream().filter(
                e->e.getBoard().getId().equals(boardId))
                .collect(Collectors.toList());
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
