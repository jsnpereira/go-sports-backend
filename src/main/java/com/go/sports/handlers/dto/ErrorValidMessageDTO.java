package com.go.sports.handlers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorValidMessageDTO {
    private String field;
    private String message;

    public ErrorValidMessageDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public ErrorValidMessageDTO() {
    }
}
