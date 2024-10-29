package com.nmc.filestorageservice.controller;

import com.nmc.filestorageservice.dto.core.BaseResponseDTO;
import com.nmc.filestorageservice.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
@Slf4j
public class FileUploadController {

    @Autowired
    FileService fileService;

    @PostMapping("/single-file-upload")
    BaseResponseDTO uploadSingleFile(@RequestParam("imageFile") MultipartFile imageFile,
                                     @RequestParam("userName") String userName) {
        log.info("Start uploadSingleFile with userName {}", userName);
        String imageUrl = fileService.saveFile(imageFile, userName);
        log.info("End uploadSingleFile with imageUrl {}", imageUrl);
        return BaseResponseDTO.success(imageUrl);
    }
    @PostMapping("/multi-file-upload")
    BaseResponseDTO uploadMultiFile(@RequestParam("imageFile") MultipartFile imageFile,
                                     @RequestParam("userName") String userName) {
        log.info("Start uploadSingleFile with userName {}", userName);
        String imageUrl = fileService.saveFile(imageFile, userName);
        log.info("End uploadSingleFile with imageUrl {}", imageUrl);
        return BaseResponseDTO.success(imageUrl);
    }
}
