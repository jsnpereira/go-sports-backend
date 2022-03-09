package com.go.sports.dto.mapper;

import com.go.sports.dto.request.EventDTO;
import com.go.sports.dto.request.RegistrationDTO;
import com.go.sports.entity.Event;
import com.go.sports.entity.Registration;

public class RegistrationMapper {
    public static RegistrationDTO toDTO(Registration registration){
        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setId(registration.getId());
        registrationDTO.setRegisterStatus(registration.getRegisterStatus());
        registrationDTO.setDate(registration.getDate());
        registrationDTO.setCategoryDTO(CategoryMapper.toDTO(registration.getCategory()));
        return registrationDTO;
    }


}
