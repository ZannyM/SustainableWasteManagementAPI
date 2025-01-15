package com.enviro.assessment.grad001.zannymaholobela.dto;

import com.enviro.assessment.grad001.zannymaholobela.dto.ResponseMessage;


public class ResponseMessage {
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
