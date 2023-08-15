package com.example.CrudeApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyGlobalException {

    @ExceptionHandler(MySalaryBusinessException.class)
    public ErrorResponse getReponse(MySalaryBusinessException exception)
    {
        return new ErrorResponse(605,exception.getMessage());

    }


}
