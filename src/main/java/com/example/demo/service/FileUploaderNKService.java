package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploaderNKService {
    void uploadFile(MultipartFile fileLoaction)throws IOException;
}
