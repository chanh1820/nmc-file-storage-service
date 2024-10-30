package com.nmc.filestorageservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class MvcConfig implements WebMvcConfigurer {

    @Value("${app.image.upload-dir}")
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String osName = System.getProperty("os.name").toLowerCase();
        log.info("osName operating system: {}", osName);
        log.info("uploadDir: {}", uploadDir);
        if (osName.contains("win")) {
            registry.addResourceHandler("/resource/**")
                    .addResourceLocations("file:" + System.getProperty("user.dir") + "/uploads/");
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("mac")) {
            registry.addResourceHandler("/resource/**")
                    .addResourceLocations("file:" + uploadDir);
        } else {
            log.info("Unknown operating system: {}", osName);
        }

    }
}