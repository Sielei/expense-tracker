package com.et.backend.application.rest;

import com.et.backend.application.auth.dto.CreateUserDto;
import com.et.backend.application.auth.dto.LoginDto;
import com.et.backend.application.auth.util.JwtUtil;
import com.et.user.application.service.dto.UserDto;
import com.et.user.application.service.ports.input.service.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserApplicationService userApplicationService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody CreateUserDto createUserDto){
        UserDto userDto = userApplicationService.createUser(UserDto.builder()
                .username(createUserDto.getUsername())
                .email(createUserDto.getEmail())
                .password(bCryptPasswordEncoder.encode(createUserDto.getPassword()))
                .build());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(createUserDto.getUsername(),
                createUserDto.getPassword());
        authenticationManager.authenticate(authenticationToken);
        String jwtToken = jwtUtil.generateJWTToken(userDto);

        return new ResponseEntity<>(jwtToken, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto){
        UserDto userDto = userApplicationService.findUserByUsername(loginDto.getUsername()).get();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(),
                loginDto.getPassword());
        authenticationManager.authenticate(authenticationToken);
        String jwtToken = jwtUtil.generateJWTToken(userDto);

        return new ResponseEntity<>(jwtToken, HttpStatus.OK);
    }
}
