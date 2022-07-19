package com.et.user.application.service.ports.input.service;

import com.et.user.application.service.dto.UserDto;

import java.util.Optional;
import java.util.UUID;

public interface UserApplicationService {

    UserDto createUser(UserDto userDto);
    Optional<UserDto> findUserById(UUID userId);
    Optional<UserDto> findUserByUsername(String username);
    Optional<UserDto> findUserByEmail(String email);
    UserDto updateUserDetails(UUID userId, UserDto userDto);

    UserDto updateUserPassword(UUID userId, String newPassword);
}
