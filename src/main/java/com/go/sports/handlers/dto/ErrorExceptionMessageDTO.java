package com.go.sports.handlers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties()
public class ErrorExceptionMessageDTO {
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime dateTime;
    private List<ErrorValidMessageDTO> errorList;

    public ErrorExceptionMessageDTO(LocalDateTime dateTime, List<ErrorValidMessageDTO> errorList) {
        this.dateTime = dateTime;
        this.errorList = errorList;
    }


    public ErrorExceptionMessageDTO() {
    }
}
