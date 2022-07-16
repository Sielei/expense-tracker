package com.et.user.application.service.ports.input.service;

import com.et.user.application.service.ports.output.repository.UserRepository;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.et")
public class UserApplicationTestConfig {

    @Bean
    UserRepository userRepository(){
        return Mockito.mock(UserRepository.class);
    }
}
