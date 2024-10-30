package com.nmc.filestorageservice.controller;

import com.nmc.filestorageservice.dto.core.BaseResponseDTO;
import com.nmc.filestorageservice.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/file")
@Slf4j
public class FileUploadController {

    @Autowired
    FileService fileService;

    @PostMapping("/single-file-upload")
    BaseResponseDTO uploadSingleFile(@RequestParam("file") MultipartFile file,
                                     @RequestParam("userName") String userName) {
        log.info("Start uploadSingleFile with userName {}", userName);
        String fileUrl = fileService.saveFile(file, userName);
        log.info("End uploadSingleFile with fileUrl {}", fileUrl);
        return BaseResponseDTO.success(fileUrl);
    }
    @PostMapping("/multi-file-upload")
    BaseResponseDTO<List<String>> uploadMultiFile(@RequestParam("files") MultipartFile[] files,
                                                  @RequestParam("userName") String userName) {
        log.info("Start uploadSingleFile with userName {}", userName);
        List<String> filesSaved = fileService.saveMultiFile(files, userName);
        log.info("End uploadSingleFile with imageUrl {}", filesSaved);
        return BaseResponseDTO.success(filesSaved);
    }
}
