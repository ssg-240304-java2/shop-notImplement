package com.ohgiraffers.notimplement.board.model.service;

import com.ohgiraffers.notimplement.board.model.dto.FileDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
@Slf4j
public class FileUploadService {

    @Value("${ftp.server.host}")
    private String server;

    @Value("${ftp.server.port}")
    private int port;

    @Value("${ftp.server.username}")
    private String username;

    @Value("${ftp.server.password}")
    private String password;

    public FileDTO upload(MultipartFile multipartFile) throws IOException {
        log.info("service파일 접근");
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

            try (InputStream inputStream = multipartFile.getInputStream()) {
                String contentType = multipartFile.getContentType();
                String originalFilename = multipartFile.getOriginalFilename();
                String dir = "/";
                String renamedFilename = getRenamedFilename(originalFilename);
                // 실제 파일전송
                boolean done = ftpClient.storeFile(dir + renamedFilename, inputStream);
                System.out.println("파일전송 url : " + dir+renamedFilename);
                if (!done)
                    throw new RuntimeException("[" + multipartFile + "] 파일 업로드에 실패했습니다.");

                // Builder패턴을 사용한 객체 생성
                return FileDTO.builder()
                        .originalFilename(originalFilename)
                        .renamedFilename(renamedFilename)
                        .contentType(contentType)
                        .fileUrl(dir+renamedFilename)
                        .build();
            }
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String getRenamedFilename(String originalFilename) {
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        return "%s%s".formatted(UUID.randomUUID().toString(), ext);
    }
}
