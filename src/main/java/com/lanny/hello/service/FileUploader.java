package com.lanny.hello.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploader {
    Object upload(MultipartFile file);
}
