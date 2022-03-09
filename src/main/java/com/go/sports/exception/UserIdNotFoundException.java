package com.go.sports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserIdNotFoundException  extends Exception{
    public UserIdNotFoundException(String value) {
        super(String.format("User id [%s] not found", value));
    }
}
