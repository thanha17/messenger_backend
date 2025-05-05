package com.social.messenger.controllers;

import com.social.messenger.services.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
public class UploadController {

    private final UploadService uploadService;

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            return uploadService.uploadFile(file);
        } catch (Exception e) {
            return "Upload failed: " + e.getMessage();
        }
    }
}
