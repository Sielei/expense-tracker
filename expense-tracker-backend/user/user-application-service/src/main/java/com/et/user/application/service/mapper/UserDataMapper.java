package com.et.user.application.service.mapper;

import com.et.user.application.service.dto.UserDto;
import com.et.user.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper {
    public User userDtoToUser(UserDto userDto) {
        return User
                .builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }

    public UserDto userToUserDto(User user) {
        return UserDto
                .builder()
                .userId(user.getId().getValue().toString())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
