package com.et.user.application.service.config;

import com.et.user.domain.service.UserDomainService;
import com.et.user.domain.service.UserDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserApplicationServiceConfig {

    @Bean
    public UserDomainService userDomainService(){
        return new UserDomainServiceImpl();
    }
}
