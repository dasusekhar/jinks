package com.example.CrudeApplication.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse
{

    private int statusCode;
    private String message;

    public ErrorResponse(int value, String message)
    {
        super();
        this.message = message;
    }



}
