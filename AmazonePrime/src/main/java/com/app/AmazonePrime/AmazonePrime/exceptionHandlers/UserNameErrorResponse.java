package com.app.AmazonePrime.AmazonePrime.exceptionHandlers;

public class UserNameErrorResponse {

    private int status;
    private String message;
    private Long timeStamp;

    public UserNameErrorResponse(int status,String message,Long timeStamp){
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
    public UserNameErrorResponse(){}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

}
