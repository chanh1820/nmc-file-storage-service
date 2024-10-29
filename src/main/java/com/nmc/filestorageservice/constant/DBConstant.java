package com.nmc.filestorageservice.constant;

import org.springframework.http.HttpStatus;

public class DBConstant {

    public static final String STATUS_SUCCESS = String.valueOf(HttpStatus.OK.value());
    public static final String STATUS_INTERNAL_SERVER_ERROR = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
    public static final String STATUS_BAD_REQUEST = String.valueOf(HttpStatus.BAD_REQUEST.value());

}
