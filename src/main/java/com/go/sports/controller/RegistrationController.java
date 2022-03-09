package com.go.sports.controller;

import com.go.sports.dto.request.RegistrationDTO;
import com.go.sports.dto.request.RegistrationPostDTO;
import com.go.sports.exception.CategoryNotFoundException;
import com.go.sports.exception.UserIdNotFoundException;
import com.go.sports.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/event")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEventByRegistration(@RequestBody @Valid RegistrationPostDTO registrationEventDTO)
            throws CategoryNotFoundException, UserIdNotFoundException {
        registrationService.registerEventByUser(registrationEventDTO);
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<RegistrationDTO> getRegisterListByUser(@PathVariable(name = "id") String userId)
            throws UserIdNotFoundException {
        return  registrationService.getRegisterListByUser(userId);
    }
}
