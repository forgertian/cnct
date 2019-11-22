package com.cnct.controller;

import com.cnct.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @PostMapping("upload/image")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file){
        String url = uploadService.upload(file);
        System.out.println(url);
        return ResponseEntity.ok(url);
    }
}
