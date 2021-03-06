package com.et.user.application.service.ports.input.helper;

import com.et.common.domain.valueobject.UserId;
import com.et.user.application.service.dto.UserDto;
import com.et.user.application.service.mapper.UserDataMapper;
import com.et.user.application.service.ports.output.repository.UserRepository;
import com.et.user.domain.entity.User;
import com.et.user.domain.service.UserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateUserHandler {

    private final UserDomainService userDomainService;
    private final UserRepository userRepository;
    private final UserDataMapper userDataMapper;
    @Transactional
    public UserDto createUser(UserDto userDto) {
        User userDtoToUser = userDataMapper.userDtoToUser(userDto);
        userDomainService.createUser(userDtoToUser);
        User newUser = userRepository.save(userDtoToUser);
        return userDataMapper.userToUserDto(newUser);
    }

    @Transactional
    public UserDto updateUserDetails(UUID userId, UserDto userDto) {
        User userToUpdate = userRepository.findUserById(new UserId(userId)).get();
        userDomainService.updateUser(userToUpdate, userDto.getEmail(), userDto.getUsername());
        return userDataMapper.userToUserDto(userRepository.updateUser(userToUpdate));
    }

    @Transactional
    public UserDto updateUserPassword(UUID userId, String newPassword) {
        User userToUpdate = userRepository.findUserById(new UserId(userId)).get();
        userDomainService.updateUserPassword(userToUpdate, newPassword);
        return userDataMapper.userToUserDto(userRepository.updatePassword(userToUpdate));
    }
}
