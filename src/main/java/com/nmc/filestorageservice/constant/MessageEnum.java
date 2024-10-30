package com.nmc.filestorageservice.constant;

import org.springframework.http.HttpStatus;

public enum MessageEnum {

    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "Internal server error"),
    FILE_IS_EMPTY("FILE_IS_EMPTY", "File is empty");


    private String messageCode;

    private String message;

    private MessageEnum(String messageCode, String message) {
        this.messageCode = messageCode;
        this.message = message;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
