package com.go.sports.service;

import com.go.sports.dto.mapper.UserMapper;
import com.go.sports.dto.request.UserDTO;
import com.go.sports.entity.User;
import com.go.sports.exception.UserIdNotFoundException;
import com.go.sports.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserById(String id) throws UserIdNotFoundException {
       Optional<User> user = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new UserIdNotFoundException(id)));
       if (user.isPresent()){
            return UserMapper.toDTO(user.get());
       }
       return UserMapper.toDTO(new User());
    }
}
