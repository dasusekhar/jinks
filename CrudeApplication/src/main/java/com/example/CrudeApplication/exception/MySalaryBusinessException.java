package com.example.CrudeApplication.exception;

public class MySalaryBusinessException extends RuntimeException{

    private int statusCode;
    private String message;


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MySalaryBusinessException() {}

    public MySalaryBusinessException(int statusCode,String msg)
    {
       super();
        this.statusCode=statusCode;
        this.message = msg;
    }
}
