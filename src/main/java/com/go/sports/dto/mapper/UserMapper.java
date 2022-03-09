package com.go.sports.dto.mapper;

import com.go.sports.dto.request.UserDTO;
import com.go.sports.entity.User;

public class UserMapper {
    public static UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        return userDTO;
    }
}
