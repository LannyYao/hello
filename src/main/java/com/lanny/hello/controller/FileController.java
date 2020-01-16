package com.lanny.hello.controller;

import com.lanny.hello.service.FileUploader;
import com.lanny.hello.service.ImageFileUploader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    @PostMapping("/files")
    public Object upload(@RequestParam("file") MultipartFile file, @RequestParam String type) {

        FileUploader fileUploader;

        switch (type.toLowerCase()) {
            case "image":
                fileUploader = new ImageFileUploader();
                break;
            default:
                throw new RuntimeException("No supported type");
        }
        return fileUploader.upload(file);
    }
}
