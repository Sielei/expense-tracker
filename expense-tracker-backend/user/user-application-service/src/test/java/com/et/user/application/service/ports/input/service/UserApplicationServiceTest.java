package com.et.user.application.service.ports.input.service;

import com.et.common.domain.valueobject.UserId;
import com.et.user.application.service.dto.UserDto;
import com.et.user.application.service.mapper.UserDataMapper;
import com.et.user.application.service.ports.output.repository.UserRepository;
import com.et.user.domain.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = UserApplicationTestConfig.class)
class UserApplicationServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserApplicationService userApplicationService;

    @Autowired
    private UserDataMapper userDataMapper;

    private UserDto userDto;

    @BeforeAll
    void init(){
        userDto = UserDto
                .builder()
                .username("Anonymous")
                .email("anonymous@gmail.com")
                .password("password")
                .build();
        User user = userDataMapper.userDtoToUser(userDto);
        user.setId(new UserId(UUID.randomUUID()));
        when(userRepository.save(any(User.class))).thenReturn(user);
    }

    @Test
    void testCreateUser(){
        UserDto newUser = userApplicationService.createUser(userDto);
        assertNotNull(newUser);
        assertEquals(newUser.getUsername(), "Anonymous");
    }

}