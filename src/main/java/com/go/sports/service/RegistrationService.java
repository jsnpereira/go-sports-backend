package com.go.sports.service;

import com.go.sports.dto.request.RegistrationEventDTO;
import com.go.sports.entity.Category;
import com.go.sports.entity.Registration;
import com.go.sports.entity.User;
import com.go.sports.enums.RegisterStatus;
import com.go.sports.exception.CategoryNotFoundException;
import com.go.sports.exception.UserIdNotFoundException;
import com.go.sports.repository.CategoryRepository;
import com.go.sports.repository.RegistrationRepository;
import com.go.sports.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class RegistrationService {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private RegistrationRepository registrationRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.registrationRepository = registrationRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public void registerEventByUser(RegistrationEventDTO registrationEventDTO) throws CategoryNotFoundException, UserIdNotFoundException {
        Optional<Category> category = Optional.ofNullable(categoryRepository.findById(registrationEventDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(registrationEventDTO.getCategoryId())));
        Optional<User> user = Optional.ofNullable(userRepository.findById(registrationEventDTO.getUserId())
                .orElseThrow(() -> new UserIdNotFoundException(registrationEventDTO.getUserId())));

        if (category.isPresent() && user.isPresent()){
            Registration registration = new Registration();
            registration.setCategory(category.get());
            registration.setRegisterStatus(RegisterStatus.OPEN);
            registration.setUser(user.get());
            LocalDate now = LocalDate.now();
            registration.setDate(now);
            registrationRepository.save(registration);
        }
    }

}
