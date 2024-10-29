package com.nmc.filestorageservice.dto.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nmc.filestorageservice.constant.DBConstant;
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

    public static <D> BaseResponseDTO<D> success() {
        return new BaseResponseDTO<>(DBConstant.STATUS_SUCCESS, null, null, null);
    }

    public static <D> BaseResponseDTO<D> success(D data) {
        return new BaseResponseDTO<>(DBConstant.STATUS_SUCCESS, null, null, data);
    }

    public static <D> BaseResponseDTO<D> success(String messageCode, String message) {
        return new BaseResponseDTO<>(DBConstant.STATUS_SUCCESS, messageCode, message, null);
    }

//    public static <D> BaseResponseDTO<D> success(MessageEnum messageEnum) {
//        return new BaseResponseDTO<>(HttpStatus.OK.value(), messageEnum.getMessageCode(), messageEnum.getMessage(), null);
//    }
}
