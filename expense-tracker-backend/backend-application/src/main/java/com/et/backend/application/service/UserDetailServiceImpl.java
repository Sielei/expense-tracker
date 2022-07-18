package com.et.backend.application.service;

import com.et.user.application.service.dto.UserDto;
import com.et.user.application.service.ports.input.service.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserApplicationService userApplicationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDto> optionalUserDto = userApplicationService.findUserByUsername(username);
        return new User(optionalUserDto.get().getUsername(), optionalUserDto.get().getPassword(), new ArrayList<>());
    }
}
