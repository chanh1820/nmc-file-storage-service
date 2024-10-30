package com.nmc.filestorageservice.exception;

import com.nmc.filestorageservice.dto.core.BaseResponseDTO;
import com.nmc.filestorageservice.exception.AppException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<BaseResponseDTO<String>> handleAppException(HttpServletRequest request, AppException ex) {
        log.error("Request method: {}, url: {}, AppException: {}", request.getMethod(), request.getRequestURI(), ex);
        return ResponseEntity
                .badRequest()
                .body(BaseResponseDTO.badRequest(ex.getErrorCode(), ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponseDTO<String>> handleGlobalException(HttpServletRequest request, Exception ex) {
        log.error("Request method: {}, url: {}, Exception: {}", request.getMethod(), request.getRequestURI(), ex);
        return ResponseEntity.of(Optional.of(BaseResponseDTO.fail(ex.getMessage())));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaseResponseDTO<String>> handleRuntimeException(HttpServletRequest request,
                                                                       RuntimeException ex) {
        log.error("Request method: {}, url: {}, RuntimeException: {}", request.getMethod(), request.getRequestURI(),
                ex);
        return ResponseEntity.of(Optional.of(BaseResponseDTO.fail(ex.getMessage())));
    }

}