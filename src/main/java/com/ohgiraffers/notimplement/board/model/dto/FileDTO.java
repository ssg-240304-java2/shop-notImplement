package com.ohgiraffers.notimplement.board.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class FileDTO {
    private Long id;
    private String contentType;
    private String originalFilename;    // 실제 업로드한 파일 이름
    private String renamedFilename;     // unique 한 파일 이름을 만들기 위한 속성
    private String fileUrl;
}
