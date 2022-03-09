package com.go.sports.dto.request;

import com.go.sports.entity.Registration;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDTO {
    private String id;
    private String name;
    private String email;
    private List<Registration> registrations;
}
