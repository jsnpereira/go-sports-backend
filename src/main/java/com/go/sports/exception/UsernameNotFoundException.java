package com.go.sports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends Exception{
    public UsernameNotFoundException(String email) {
        super(String.format("E-mail[%s] not found",email));
    }
}
