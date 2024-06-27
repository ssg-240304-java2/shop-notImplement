package com.ohgiraffers.notimplement.board.model.dao;

import com.ohgiraffers.notimplement.board.model.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface InquiryMapper {
    int saveInquiry(BoardDTO boardDTO);

    int updateInquiry(BoardDTO boardDTO);

    int deleteInquiry(int boardSeq);

    List<BoardDTO> showBoardList(Map<String, String> map);

    BoardDTO findByBoardSeq(int boardSeq);

    int saveInquiryAnswer(BoardDTO boardDTO);

    int getCountNotAnswer();
}
