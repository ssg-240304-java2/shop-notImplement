package com.ohgiraffers.notimplement.board.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardDTO {

    private int boardSeq;
    private String boardCategory;
    private String boardTitle;
    private String boardContent;
    private Timestamp regDate;
    private Timestamp updateDate;
    private String userId;
    private String answer;
    private boolean boardDel;

    public BoardDTO(String boardTitle, String boardContent, String userId, String boardCategory, String answer) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.userId = userId;
        this.boardCategory=boardCategory;
        this.answer = answer;
    }

}
