package com.nmc.filestorageservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    public String saveFile(MultipartFile multipartFile, String userName);
    public List<String> saveMultiFile(MultipartFile[] multipartFile, String userName);
}
