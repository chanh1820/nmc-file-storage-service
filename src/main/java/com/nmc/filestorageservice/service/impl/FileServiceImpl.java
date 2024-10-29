package com.nmc.filestorageservice.service.impl;

import com.nmc.filestorageservice.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class FileServiceImpl implements FileService {
    private static final String UUID_REPLACE_USERNAME = "7c636a5593784e56ac37cacd2520298c";
    private String uploadDirTemplate = "/usr/local/app/"+ UUID_REPLACE_USERNAME+ "/";

    @Override
    public String saveFile(MultipartFile file, String userName) {
        String fileName = "";
        try {
            fileName = file.getOriginalFilename();
            Path filePath = Paths.get(getPathUploadFile(userName), fileName);
            Files.write(filePath, file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public String getPathUploadFile(String userName){
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
//            log.info("System OS is {}, FILE_PATH is {}", osName, "/uploads/");
            return System.getProperty("user.dir").replace("\\", "/") + "/uploads";
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("mac")) {
            String uploadDir =  uploadDirTemplate.replace(UUID_REPLACE_USERNAME,userName);
            if(!isPathExisting(uploadDir)){
                try {
                    Files.createDirectories(Paths.get(uploadDir));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return uploadDir;
        } else {
            log.info("Unknown operating system: {}", osName);
            String uploadDir =  uploadDirTemplate.replace(UUID_REPLACE_USERNAME,userName);
            if(!isPathExisting(uploadDir)){
                try {
                    Files.createDirectories(Paths.get(uploadDir));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return uploadDir;
        }
    }

    public boolean isPathExisting(String directoryPath){
        Path path = Paths.get(directoryPath);
        if (!Files.exists(path)) {
            log.info("{} is existing", directoryPath);
            return false;
        } else {
            return true;
        }
    }
}
