package com.go.sports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException(String id){
        super(String.format("Category with ID %s not found",id));
    }
}
