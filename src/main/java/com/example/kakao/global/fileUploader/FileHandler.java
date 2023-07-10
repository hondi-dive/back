package com.example.kakao.global.fileUploader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
public class FileHandler {

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${app.base-url}")
    private String baseUrl;

    public String uploadFile(MultipartFile file) {
        try {
            // 파일 이름 생성
            String contentType = file.getContentType();
            String fileName = StringUtils.cleanPath(UUID.randomUUID().toString() + "." +contentType.substring(contentType.lastIndexOf('/') + 1));
            // 파일 저장 경로 설정
            Resource resource = resourceLoader.getResource("classpath:static/imgStorage/");
            String uploadDir = resource.getFile().getAbsolutePath();
            String filePath = Paths.get(uploadDir, fileName).toString();

            // 파일 저장
            Path targetLocation = Paths.get(filePath);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String fileUrl = baseUrl + "/imgStorage/" + fileName;
            System.out.println(fileUrl);
            return fileUrl;
        } catch (IOException ex) {
            throw new RuntimeException("Failed to upload file");
        }
    }
}
