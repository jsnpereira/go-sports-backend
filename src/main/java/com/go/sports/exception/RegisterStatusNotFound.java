package com.go.sports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegisterStatusNotFound extends Exception{
    public RegisterStatusNotFound(String value){
        super(String.format("Register status [%s] not found",value));
    }
}
