package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploaderService {
    void uploadFile(MultipartFile fileLoaction)throws IOException;
    void uploadFilenk(MultipartFile fileLoaction)throws IOException;
}
