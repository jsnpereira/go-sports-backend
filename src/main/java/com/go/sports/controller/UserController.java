package com.go.sports.controller;

import com.go.sports.dto.request.UserDTO;
import com.go.sports.exception.UserIdNotFoundException;
import com.go.sports.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable(name = "id") String userId) throws UserIdNotFoundException {
        UserDTO user;
        user = userService.getUserById(userId);
        return user;
    }

}
