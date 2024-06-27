package com.ohgiraffers.notimplement.board.controller;

import com.ohgiraffers.notimplement.board.model.dto.FileDTO;
import com.ohgiraffers.notimplement.board.model.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
public class FileController {

    @Value("${spring.servlet.multipart.location}")
    private String location;

    private final FileUploadService fileUploadService;

    public FileController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/image-upload")
    @ResponseBody
    public String uploadImage(@RequestParam MultipartFile file) throws IOException {

        log.debug("check");
        // 1. 파일업로드 처리
        List<FileDTO> list = new ArrayList<>();
//        for (MultipartFile file : upFiles) {
            if (!file.isEmpty()) {
                FileDTO fileDto = fileUploadService.upload(file);
                list.add(fileDto);
            }
//        }
        log.debug("list = {}", list);
        // 2. 업로드한 파일명/저장된 파일명 정보를 DB 등록
        return list.get(0).getFileUrl();
    }

}
