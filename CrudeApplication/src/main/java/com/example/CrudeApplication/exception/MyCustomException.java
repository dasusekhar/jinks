package com.example.CrudeApplication.exception;

public class MyCustomException extends RuntimeException{

    private String message;
    public MyCustomException(String message)
    {
        this.message=message;
    }
    public String getMessage()
    {
        return message;
    }
}
