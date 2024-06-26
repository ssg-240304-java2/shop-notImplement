package com.ohgiraffers.notimplement.board.model.service;

import com.ohgiraffers.notimplement.board.model.dao.InquiryMapper;
import com.ohgiraffers.notimplement.board.model.dto.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class InquiryService {

    private final InquiryMapper inquiryMapper;

    public InquiryService(InquiryMapper inquiryMapper) {
        this.inquiryMapper = inquiryMapper;
    }

    public boolean saveInquiry(BoardDTO boardDTO) {
       int saveResult = inquiryMapper.saveInquiry(boardDTO);
       return saveResult != 0;
    }

    public boolean updateInquiry(BoardDTO boardDTO) {
        int updateResult = inquiryMapper.updateInquiry(boardDTO);
        return updateResult != 0;
    }

    public boolean deleteInquiry(int boardSeq) {
        int deleteResult = inquiryMapper.deleteInquiry(boardSeq);
        return deleteResult != 0;
    }

    public List<BoardDTO> showBoardList(String status, String strDate,String endDate) {
        Map<String,String> map = new HashMap<>();
        map.put("status", status);
        map.put("strDate", strDate);
        map.put("endDate", endDate);
        return inquiryMapper.showBoardList(map);
    }

    public BoardDTO findByBoardSeq(int boardSeq) {
        return inquiryMapper.findByBoardSeq(boardSeq);
    }

    public boolean saveInquiryAnswer(BoardDTO boardDTO) {
        int saveAnswer = inquiryMapper.saveInquiryAnswer(boardDTO);
        return saveAnswer != 0;
    }

    public int getCountNotAnswer() {
        return inquiryMapper.getCountNotAnswer();
    }
}
