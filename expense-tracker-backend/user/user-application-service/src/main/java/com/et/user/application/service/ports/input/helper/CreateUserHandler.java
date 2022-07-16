package com.et.user.application.service.ports.input.helper;

import com.et.user.application.service.dto.UserDto;
import com.et.user.application.service.mapper.UserDataMapper;
import com.et.user.application.service.ports.output.repository.UserRepository;
import com.et.user.domain.entity.User;
import com.et.user.domain.service.UserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
}
