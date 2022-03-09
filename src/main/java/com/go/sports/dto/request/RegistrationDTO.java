package com.go.sports.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.go.sports.enums.RegisterStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RegistrationDTO {
    private String id;
    @JsonProperty("category")
    private CategoryDTO categoryDTO;
    private LocalDate date;
    private RegisterStatus registerStatus;
}
