package com.et.user.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class UserDto {
    private String userId;
    private String username;
    private String email;
    private String password;
}
