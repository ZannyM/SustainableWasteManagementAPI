package com.enviro.assessment.grad001.zannymaholobela.dto;

import com.enviro.assessment.grad001.zannymaholobela.dto.ResponseMessage;

/**
 * This class represents a generic response message that can be used to convey success
 * or error messages to the client.
 */
public class ResponseMessage {
    private String message;
    /**
     * Constructs a new ResponseMessage object with the given message.
     *
     * @param message The message to be conveyed.
     */
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
