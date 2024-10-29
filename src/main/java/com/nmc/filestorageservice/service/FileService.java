package com.nmc.filestorageservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public interface FileService {

    public String saveFile(MultipartFile multipartFile, String userName);
}
