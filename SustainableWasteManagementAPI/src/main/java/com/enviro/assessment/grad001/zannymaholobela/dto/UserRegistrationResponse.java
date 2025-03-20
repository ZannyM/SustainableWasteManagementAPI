package com.enviro.assessment.grad001.zannymaholobela.dto;

public class UserRegistrationResponse {
    private String uid;
    private String email;
    private String message;

    public UserRegistrationResponse() {
    }

    public UserRegistrationResponse(String uid, String email, String message) {
        this.uid = uid;
        this.email = email;
        this.message = message;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}