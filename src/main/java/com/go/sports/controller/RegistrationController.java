package com.go.sports.controller;

import com.go.sports.dto.request.RegistrationEventDTO;
import com.go.sports.exception.CategoryNotFoundException;
import com.go.sports.exception.UserIdNotFoundException;
import com.go.sports.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/event")
    public void addEventByRegistration(@RequestBody @Valid RegistrationEventDTO registrationEventDTO)
            throws CategoryNotFoundException, UserIdNotFoundException {
        registrationService.registerEventByUser(registrationEventDTO);
    }
}
