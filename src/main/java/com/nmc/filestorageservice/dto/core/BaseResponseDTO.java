package com.nmc.filestorageservice.dto.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nmc.filestorageservice.constant.DBConstant;
import com.nmc.filestorageservice.constant.MessageEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponseDTO<D> {

    private String statusCode = DBConstant.STATUS_SUCCESS;

    private String messageCode;

    private String message;

    private D data;
    public static <T> BaseResponseDTO<T> success() {
        return new BaseResponseDTO<>(String.valueOf(HttpStatus.OK.value()), null, null, null);
    }

    public static <T> BaseResponseDTO<T> success(T data) {
        return new BaseResponseDTO<>(String.valueOf(HttpStatus.OK.value()), null, null, data);
    }

    public static <T> BaseResponseDTO<T> success(String messageCode, String message) {
        return new BaseResponseDTO<>(String.valueOf(HttpStatus.OK.value()), messageCode, message, null);
    }

    public static <T> BaseResponseDTO<T> success(MessageEnum messageEnum) {
        return new BaseResponseDTO<>(String.valueOf(HttpStatus.OK.value()), messageEnum.getMessageCode(), messageEnum.getMessage(), null);
    }

    public static <T> BaseResponseDTO<T> badRequest(T data) {
        return new BaseResponseDTO<>(String.valueOf(HttpStatus.BAD_REQUEST.value()), null, null, data);
    }

    public static <T> BaseResponseDTO<T> badRequest(String messageCode, String message) {
        return new BaseResponseDTO<>(String.valueOf(HttpStatus.BAD_REQUEST.value()), messageCode, message, null);
    }

    public static <T> BaseResponseDTO<T> badRequest(String messageCode, String message, T data) {
        return new BaseResponseDTO<>(String.valueOf(HttpStatus.BAD_REQUEST.value()), messageCode, message, data);
    }

    public static <T> BaseResponseDTO<T> badRequest(String message, T data) {
        return new BaseResponseDTO<>(String.valueOf(HttpStatus.BAD_REQUEST.value()), null, message, data);
    }

    public static <T> BaseResponseDTO<T> badRequest(MessageEnum messageEnum) {
        return new BaseResponseDTO<>(
                String.valueOf(HttpStatus.BAD_REQUEST.value()),
                messageEnum.getMessageCode(), messageEnum.getMessage(), null);
    }

    public static <T> BaseResponseDTO<T> fail(String message) {
        return new BaseResponseDTO<>(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), null, message, null);
    }

    public static <T> BaseResponseDTO<T> fail(MessageEnum messageEnum) {
        return new BaseResponseDTO<>(
                String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                messageEnum.getMessageCode(), messageEnum.getMessage(), null);
    }

    public static <T> BaseResponseDTO<T> unAuthorized(String message) {
        return new BaseResponseDTO<>(String.valueOf(HttpStatus.UNAUTHORIZED.value()), null, message, null);
    }

    public static <T> BaseResponseDTO<T> unAuthorized(MessageEnum messageEnum) {
        return new BaseResponseDTO<>(
                String.valueOf(HttpStatus.UNAUTHORIZED.value()),
                messageEnum.getMessageCode(), messageEnum.getMessage(), null);
    }

    public static <T> BaseResponseDTO<T> accessDenied(String message) {
        return new BaseResponseDTO<>(String.valueOf(HttpStatus.FORBIDDEN.value()), null, message, null);
    }

    public static <T> BaseResponseDTO<T> accessDenied(MessageEnum messageEnum) {
        return new BaseResponseDTO<>(
                String.valueOf(HttpStatus.FORBIDDEN.value()),
                messageEnum.getMessageCode(), messageEnum.getMessage(), null);
    }
}
