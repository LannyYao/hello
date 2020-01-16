package com.lanny.hello.service;

import org.springframework.web.multipart.MultipartFile;

public class ImageFileUploader implements FileUploader {
    @Override
    public Object upload(MultipartFile file) {
        return "image " + file.getOriginalFilename() + " has been saved";
    }
}
