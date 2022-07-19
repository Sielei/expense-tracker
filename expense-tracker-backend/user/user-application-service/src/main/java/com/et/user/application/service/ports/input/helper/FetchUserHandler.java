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

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FetchUserHandler {

    private final UserDomainService userDomainService;
    private final UserRepository userRepository;
    private final UserDataMapper userDataMapper;
    @Transactional
    public Optional<UserDto> findUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findUserByUsername(username);
        return Optional.ofNullable(userDataMapper.userToUserDto(optionalUser.get()));
    }

    public Optional<UserDto> findUserById(UUID userId) {
        Optional<User> optionalUser = userRepository.findUserById(new UserId(userId));
        return Optional.ofNullable(userDataMapper.userToUserDto(optionalUser.get()));
    }
}
