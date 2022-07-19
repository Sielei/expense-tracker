package com.et.backend.application.rest;

import com.et.backend.application.dto.PasswordDto;
import com.et.backend.application.util.JwtUtil;
import com.et.user.application.service.dto.UserDto;
import com.et.user.application.service.ports.input.service.UserApplicationService;
import com.et.user.domain.exception.UserDomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserApplicationService userApplicationService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;



    @PutMapping("/update-user-details")
    public ResponseEntity<UserDto> updateUserDetails(@RequestAttribute("userId") UUID userId, @RequestBody UserDto userDto){
        UserDto updateUserDetails = userApplicationService.updateUserDetails(userId, userDto);
        return new ResponseEntity<>(updateUserDetails, HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> updatePassword(@RequestAttribute("userId") UUID userId, @RequestBody PasswordDto passwordDto){
        UserDto userDto = userApplicationService.findUserById(userId).get();
        if (!bCryptPasswordEncoder.matches(passwordDto.getCurrentPassword(), userDto.getPassword())){
            throw new UserDomainException("Incorrect password.");
        }
        if (!passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword())){
            throw new UserDomainException("Passwords do not match!");
        }

        userApplicationService.updateUserPassword(userId, bCryptPasswordEncoder.encode(passwordDto.getNewPassword()));
        return new ResponseEntity<>("Password changed successfully!", HttpStatus.OK);
    }

}
