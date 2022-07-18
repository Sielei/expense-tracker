package com.et.user.application.service.ports.input.service;

import com.et.user.application.service.dto.UserDto;
import com.et.user.application.service.ports.input.helper.CreateUserHandler;
import com.et.user.application.service.ports.input.helper.FetchUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService{

    private final CreateUserHandler createUserHandler;
    private final FetchUserHandler fetchUserHandler;

    @Override
    public UserDto createUser(UserDto userDto) {
        return createUserHandler.createUser(userDto);
    }

    @Override
    public Optional<UserDto> findUserById(UUID userId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> findUserByUsername(String username) {
        return fetchUserHandler.findUserByUsername(username);
    }

    @Override
    public Optional<UserDto> findUserByEmail(String email) {
        return Optional.empty();
    }
}
