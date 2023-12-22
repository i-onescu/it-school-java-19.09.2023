package com.example.demo.converters.impl;

import com.example.demo.converters.ObjectConverter;
import com.example.demo.models.dtos.UserDTO;
import com.example.demo.models.entities.User;
import org.springframework.stereotype.Component;

// an implementation of ObjectConverter added into the Spring container
@Component
public class UserConverter implements ObjectConverter<User, UserDTO> {

    @Override
    public User convertSecondToFirst(UserDTO userDTO) {
        User user = new User();

        user.setAge(userDTO.age());
        user.setName(userDTO.name());
        user.setCountry(userDTO.country());
        user.setEmail(userDTO.email());

        return user;
    }

    @Override
    public UserDTO convertFirstToSecond(User user) {
        return UserDTO.builder()
                .age(user.getAge())
                .email(user.getEmail())
                .name(user.getName())
                .country(user.getCountry())
                .build();
    }
}
